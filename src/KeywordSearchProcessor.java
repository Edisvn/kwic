import java.util.ArrayList;
import java.util.List;

public class KeywordSearchProcessor {

    public void searchKeyword(String keyword, LineStorage lineStorage) {
        List<String> lines = lineStorage.getLines();
        List<String> matchingLines = new ArrayList<>();

        for (String line : lines) {
            if (containsKeyword(line, keyword)) {
                matchingLines.add(highlightKeyword(line, keyword));
            }
        }

        if (!matchingLines.isEmpty()) {
            System.out.println("Found in " + matchingLines.size() + " sentence(s):");
            for (String matchingLine : matchingLines) {
                System.out.println(matchingLine);
            }
        } else {
            System.out.println("[" + keyword + "] not found.");
        }
    }

    private boolean containsKeyword(String line, String keyword) {
        return line.toLowerCase().contains(keyword.toLowerCase());
    }

    private String highlightKeyword(String line, String keyword) {
        return line.replaceAll("(?i)" + keyword, "**" + keyword + "**");
    }
}
