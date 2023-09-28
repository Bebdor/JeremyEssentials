package de.devlucas.jeremyessentials.utils;
import java.util.ArrayList;
import java.util.List;
public class CommandRegistry {
    private static final List<Class<? extends PermissionCheckingCommand>> commands = new ArrayList<>();

    public static void register(Class<? extends PermissionCheckingCommand> commandClass) {
        commands.add(commandClass);
    }

    public static List<Class<? extends PermissionCheckingCommand>> getCommands() {
        return new ArrayList<>(commands);
    }
}
