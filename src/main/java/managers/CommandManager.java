package managers;

import commands.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandMap;
    private final ArrayList<String> keyList;

    public CommandManager() {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        commandMap.put("show", new Show());
        commandMap.put("insert", new Insert());
        commandMap.put("update", new Update());
        commandMap.put("remove_key", new RemoveKey());
        commandMap.put("clear", new Clear());
        commandMap.put("save", new Save());
        commandMap.put("execute_script", new ExecuteScript());
        commandMap.put("exit", new Exit());
        commandMap.put("history", new History());
        commandMap.put("replace_if_lower", new ReplaceIfLower());
        commandMap.put("remove_lower_key", new RemoveLowerKey());
        commandMap.put("min_by_status", new MinByStatus());
        commandMap.put("count_by_position", new CountByPosition());
        commandMap.put("filter_greater_than_organization", new FilterGreaterThanOrganization());
        this.commandMap = commandMap;
        this.keyList = new ArrayList<>(commandMap.keySet());
    }

    public Map<String, Command> getCommandMap() { return commandMap; }
    public ArrayList<String> getKeyList() { return keyList; }
    public boolean hasCommand(String string) { return keyList.contains(string); }
}
