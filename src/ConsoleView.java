import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.println("Enter command: ");
        return scanner.nextLine();
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public void displaySuccessMessage(String message) {
        System.out.println("Success! " + message);
    }

    public void displayMenu(LineStorage lineStorage) {
        System.out.println("\nBelow is a list of valid commands that can be executed. \nThis menu can be shown at any point by typing \"help\" or \"menu\".\n");
        System.out.println("==========================================");
        System.out.println("||              KWIC Program             ||");
        System.out.println("==========================================");
        System.out.println("|              = Commands =               |");
        System.out.println("| " + fixedLengthString("1. load \"filename\"", 40) + "|");
        System.out.println("| " + fixedLengthString("2. cshift (Circular Shift)", 40) + "|");
        System.out.println("| " + fixedLengthString("3. search \"keyword\"", 40) + "|");
        System.out.println("| " + fixedLengthString("4. igen (Index Generation)", 40) + "|");
        System.out.println("| " + fixedLengthString("5. menu", 40) + "|");
        System.out.println("| " + fixedLengthString("6. exit", 40) + "|");
        System.out.println("| " + fixedLengthString("", 40) + "|");
        System.out.println("| " + fixedLengthString(("Loaded File: " + lineStorage.getFileName()), 40) + "|");
        System.out.println("==========================================");
    }

    public String fixedLengthString(String string, int length) {
        return String.format("%1$-" + length + "s", string);
    }
}
