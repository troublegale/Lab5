package managers;

import commands.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandMap;
    private final ArrayList<String> keyList;
    private Object argument;

    public CommandManager(CollectionManager colMan) {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("info", new Info(colMan));
        commandMap.put("show", new Show(colMan));
        commandMap.put("insert", new Insert(colMan));
        commandMap.put("update", new Update(colMan));
        commandMap.put("remove_key", new RemoveKey(colMan));
        commandMap.put("clear", new Clear(colMan));
        commandMap.put("save", new Save(colMan));
        commandMap.put("execute_script", new ExecuteScript());
        commandMap.put("exit", new Exit());
        commandMap.put("history", new History());
        commandMap.put("replace_if_lower", new ReplaceIfLower(colMan));
        commandMap.put("remove_lower_key", new RemoveLowerKey(colMan));
        commandMap.put("min_by_status", new MinByStatus(colMan));
        commandMap.put("count_by_position", new CountByPosition(colMan));
        commandMap.put("filter_greater_than_organization", new FilterGreaterThanOrganization(colMan));
        commandMap.put("test", new Test());
        commandMap.put("help", new Help(new ArrayList<>(commandMap.values())));
        this.commandMap = commandMap;
        this.keyList = new ArrayList<>(commandMap.keySet());
    }

    public Object getArgument() {return argument; }
    public void setArgument(String argument) { this.argument = argument; }
    public Map<String, Command> getCommandMap() { return commandMap; }
    public ArrayList<String> getKeyList() { return keyList; }
    public boolean hasCommand(String string) { return keyList.contains(string); }

    public void handleCommand(String command) {
        Command currentCommand = commandMap.get(command);
        if (currentCommand.argType().equals("")) {
            currentCommand.execute(argument);
        } else {
            if (argument.equals("")) {
                System.out.println("Command '" + currentCommand.name() + "' requires an argument.");
            } else {
                switch (currentCommand.argType()) {
                    case "int" -> {
                        try {
                            argument = Integer.parseInt(argument.toString());
                            currentCommand.execute(argument);

                        } catch (NumberFormatException e) {
                            System.out.println("Wrong argument for '" + currentCommand.name() + "' - an integer value required.");
                        }
                    }
                    case "long" -> {
                        try {
                            argument = Long.parseLong(argument.toString());
                            currentCommand.execute(argument);
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong argument for '" + currentCommand.name() + "' - a long value required.");
                        }
                    }
//                    case ""
                }
            }
        }

    }
}
