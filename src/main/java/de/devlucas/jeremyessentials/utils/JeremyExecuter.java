package de.devlucas.jeremyessentials.utils;

import de.devlucas.jeremyessentials.JeremyEssentials;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class JeremyExecuter implements CommandExecutor, TabExecutor {

    protected JeremyExecuter() {
        CommandRegistry.register(this.getClass());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] args) {
        boolean isConsoleCommand;
        try {
            Command annotation = this.getClass().getAnnotation(Command.class);
            if (annotation != null) {
                isConsoleCommand = annotation.isConsoleCommand();
                if (!isConsoleCommand && !(commandSender instanceof Player)) {
                    commandSender.sendMessage(JeremyEssentials.mustBeAPlayer);
                    return false;
                }

                String permissionRequired = annotation.permission();
                if (!commandSender.hasPermission(permissionRequired)) {
                    commandSender.sendMessage(JeremyEssentials.noRights);
                    return false;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

        if (commandSender instanceof Player player) {
            return executeCommand(player, command, args);
        } else {
            return executeCommand(null, command, args);
        }
    }
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, @NotNull String[] args) {
        return suggestTabCompletion(sender, command, alias, args);
    }


    public abstract boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args);

    public abstract List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args);
}