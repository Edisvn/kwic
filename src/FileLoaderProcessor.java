import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoaderProcessor {
    ConsoleView consoleView = new ConsoleView();

    public void loadFile(String filename, LineStorage lineStorage) {

        lineStorage.clearLines();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineStorage.addLine(line);
            }

            consoleView.displaySuccessMessage("File loaded");
            lineStorage.setFileName(filename);

        } catch (IOException e) {
            consoleView.displayErrorMessage("File not found");
        }
    }
}
