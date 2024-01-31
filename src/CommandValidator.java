import java.util.Arrays;

public class CommandValidator {

    public CommandValidator() {}

    public boolean validateCommand(String command) {
        String[] validCommands = {"load", "cshift", "search", "igen", "exit", "menu"};
        String[] tokenizedString = command.split(" ");

        return Arrays.stream(validCommands).anyMatch(tokenizedString[0]::equalsIgnoreCase);
    }
}