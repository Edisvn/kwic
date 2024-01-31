import java.util.ArrayList;
import java.util.List;

public class LineStorage {
    private List<String> lines;
    private String fileName;

    public LineStorage() {
        this.lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    public void setFileName(String name) {
        fileName = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void clearLines() {
        lines.clear();
    }
}
