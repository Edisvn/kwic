public class CommandProcessor {
    private FileLoaderProcessor fileLoader;
    private CircularShiftProcessor circularShift;
    private KeywordSearchProcessor keywordSearch;
    private IndexGenerationProcessor indexGeneration;
    private ConsoleView consolveView;

    public CommandProcessor() {
        this.fileLoader = new FileLoaderProcessor();
        this.circularShift = new CircularShiftProcessor();
        this.keywordSearch = new KeywordSearchProcessor();
        this.indexGeneration = new IndexGenerationProcessor();
        this.consolveView = new ConsoleView();
    }

    public void processCommand(String command, LineStorage lineStorage) {
        String[] tokenizedString = command.split(" ");
        String operation = tokenizedString[0];

        switch (operation) {
            case "load":
                if(tokenizedString.length < 2) {
                    consolveView.displayErrorMessage("Please include a file name");
                    break;
                }
                fileLoader.loadFile(tokenizedString[1], lineStorage);
                break;
            case "cshift":
                if(!fileLoaded(lineStorage)) {
                    consolveView.displayErrorMessage("No file loaded");
                    break;
                }
                circularShift.processAndDisplayShift(lineStorage);
                break;
            case "search":
                if(!fileLoaded(lineStorage)) {
                    consolveView.displayErrorMessage("No file loaded");
                    break;
                }
                keywordSearch.searchKeyword(tokenizedString[1], lineStorage);
                break;
            case "igen":
                if(!fileLoaded(lineStorage)) {
                    consolveView.displayErrorMessage("No file loaded");
                    break;
                }
                indexGeneration.generateIndex(lineStorage);
                break;
            case "menu":
                consolveView.displayMenu(lineStorage);
                break;
            case "exit":
                System.exit(0);
            default:
                break;
        }
    }

    public boolean fileLoaded(LineStorage lineStorage) {
        return lineStorage.getFileName() != null;
    }
    
}
