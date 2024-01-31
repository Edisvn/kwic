import java.util.*;

public class IndexGenerationProcessor {

    public void generateIndex(LineStorage lineStorage) {
        Map<String, List<Integer>> keywordIndexMap = new TreeMap<>();

        List<String> lines = lineStorage.getLines();

        for (int lineNumber = 1; lineNumber <= lines.size(); lineNumber++) {
            String line = lines.get(lineNumber - 1);
            String[] words = line.split("\\s");

            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

            for (String word : uniqueWords) {
                word = word.toLowerCase();
                keywordIndexMap.computeIfAbsent(word, k -> new ArrayList<>()).add(lineNumber);
            }
        }

        displayIndex(keywordIndexMap);
    }

    private void displayIndex(Map<String, List<Integer>> keywordIndexMap) {
        for (Map.Entry<String, List<Integer>> entry : keywordIndexMap.entrySet()) {
            String keyword = entry.getKey();
            List<Integer> lineNumbers = entry.getValue();

            System.out.print(keyword + ": ");

            for (int i = 0; i < lineNumbers.size(); i++) {
                System.out.print(lineNumbers.get(i));
                if (i < lineNumbers.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }
    }
}
