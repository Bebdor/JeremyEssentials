package de.devlucas.jeremyessentials.utils;
import java.util.ArrayList;
import java.util.List;
public class CommandRegistry {
    private static final List<Class<? extends JeremyExecuter>> commands = new ArrayList<>();

    public static void register(Class<? extends JeremyExecuter> commandClass) {
        commands.add(commandClass);
    }

    public static List<Class<? extends JeremyExecuter>> getCommands() {
        return new ArrayList<>(commands);
    }
}
