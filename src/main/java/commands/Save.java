package commands;

import managers.CollectionManager;
import managers.FileManager;

import java.io.File;

public class Save implements Command {
    CollectionManager colMan;
    FileManager fileManager;
    public Save(CollectionManager colMan, FileManager fileManager) {
        this.colMan = colMan;
        this.fileManager = fileManager;
    }

    @Override
    public void execute(Object argument) {
        System.out.println("Saving...");
        fileManager.writeWorkersToFile(colMan);
        System.out.println("Successfully saved.");
    }
    @Override
    public String name() { return "save"; }
    @Override
    public String arg() { return ""; }
    @Override
    public String description() { return "save the collection to file"; }
    @Override
    public String argType() { return ""; }
}
