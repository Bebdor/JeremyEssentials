package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.utils.CommandRegistry;
import de.devlucas.jeremyessentials.utils.PermissionCheckingCommand;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends PermissionCheckingCommand {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        boolean hasAdminRights = player != null && player.hasPermission("essentials.admin");

        CommandRegistry.getCommands().forEach(commandClass -> {
            main annotation = commandClass.getAnnotation(main.class);
            if (annotation != null) {
                String message = "\n\n§6Command: §7" + annotation.command() +
                        "\n§6Author: §7" + annotation.author() +
                        "\n§6Description: §7" + annotation.description();
                if (hasAdminRights) {
                    message += "\n§6Required Permission: §7" + annotation.permission();
                }
                assert player != null;
                player.sendMessage(message);

            }
        });
        return true;
    }

    // implement the abstract method for tab completion
    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        // Return an empty list as there are no relevant completions for the help command
        return new ArrayList<>();
    }
}