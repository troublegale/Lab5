package commands;

import java.util.ArrayList;

public class History implements Command {
    ArrayList<String> history;

    public History(ArrayList<String> history) {
        this.history = history;
    }

    @Override
    public void execute(Object argument) {
        int historyLength = history.size();
        if (historyLength == 0) {
            System.out.println("History is yet empty.");
            return;
        }
        for (String s : history) {
            System.out.println(s);
        }
    }

    @Override
    public String name() {
        return "history";
    }

    @Override
    public String arg() {
        return "";
    }

    @Override
    public String description() {
        return "print out 6 last executed commands";
    }

    @Override
    public String argType() {
        return "";
    }
}
