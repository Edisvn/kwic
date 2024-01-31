import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircularShiftProcessor {

    public void processAndDisplayShift(LineStorage lineStorage) {
        Map<String, Integer> originalLineIndices = mapOriginalLineIndices(lineStorage);
        List<String> shiftedLines = processShift(lineStorage, originalLineIndices);
        displayShift(shiftedLines, originalLineIndices);
    }

    private Map<String, Integer> mapOriginalLineIndices(LineStorage lineStorage) {
        Map<String, Integer> originalLineIndices = new HashMap<>();

        List<String> originalLines = lineStorage.getLines();
        for (int i = 0; i < originalLines.size(); i++) {
            originalLineIndices.put(originalLines.get(i), i + 1); // Adding 1 to convert from 0-based index to 1-based index
        }

        return originalLineIndices;
    }

    private List<String> processShift(LineStorage lineStorage, Map<String, Integer> originalLineIndices) {
        List<String> shifts = new ArrayList<>();

        List<String> originalLines = lineStorage.getLines();
        for (String line : originalLines) {
            String[] words = line.split(" ");

            for (int j = 0; j < words.length; j++) {
                String shiftedLine = getShiftedLine(j, words);
                shifts.add(shiftedLine + "\t" + originalLineIndices.get(line));
            }
        }

        return shifts;
    }

    private String getShiftedLine(int index, String[] words) {
        StringBuilder builder = new StringBuilder();

        for (int i = index; i < words.length; i++) {
            builder.append(words[i]);
            builder.append(" ");
        }
        for (int i = 0; i < index; i++) {
            builder.append(words[i]);
            builder.append(" ");
        }
        if (!builder.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString().trim();
    }

    private void displayShift(List<String> shifts, Map<String, Integer> originalLineIndices) {
        Collections.sort(shifts);

        System.out.println("Index\tCircular Shifted Lines\tOriginal Line Index");
        for (int i = 0; i < shifts.size(); i++) {
            String[] parts = shifts.get(i).split("\t");
            String shiftedLine = parts[0];
            int originalLineIndex = Integer.parseInt(parts[1]);

            System.out.printf("%d\t%-30s%d\n", i + 1, shiftedLine, originalLineIndex);
        }
    }
}
