package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.utils.CommandRegistry;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends JeremyExecuter {

    /**
     * Lists all available accounts with author, description and the permissions
     * <p>
     * @param player the player executing the command
     * @param command the command to be executed
     * @param args the arguments passed with the command
     * @return true if the command was executed successfully, false otherwise
     */
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

    /**
     * implement the abstract method for tab completion
     * <p>
     * Return an empty list as there are no relevant completions for the help command
     */

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}