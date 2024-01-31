public class Main {
    public static void main(String[] args) {
        LineStorage lineStorage = new LineStorage();
        CommandProcessor processor = new CommandProcessor();
        ConsoleView consoleView = new ConsoleView();
        CommandValidator validator = new CommandValidator();

        System.out.println("==== KWIC Program ====");
        consoleView.displayMenu(lineStorage);

        while (true) {
            String userInput = consoleView.getUserInput();
            if(validator.validateCommand(userInput)) {
                processor.processCommand(userInput, lineStorage);
                System.out.print("\n");
            } else {
                consoleView.displayErrorMessage("Invalid command");
                System.out.print("\n");
            }
        }
    }
}