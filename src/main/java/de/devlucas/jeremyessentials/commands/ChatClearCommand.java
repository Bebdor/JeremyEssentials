package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.utils.PermissionCheckingCommand;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

@main(
        command = "/cc",
        permission = "jeremyessentials.chatclear",
        description = "This command clears the chat",
        isConsoleCommand = true
)
public class ChatClearCommand extends PermissionCheckingCommand {

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage("");
        }

        Bukkit.broadcastMessage("Chat has been cleared by " + (player != null ? player.getName() : "console") + ".");

        return true;
    }

    @Override public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args)
    {
        return Collections.emptyList();
    }
}