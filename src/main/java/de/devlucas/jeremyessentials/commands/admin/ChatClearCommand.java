package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * The ChatClearCommand class is a command that clears the chat.
 * <p>
 * This class extends the PermissionCheckingCommand class and is associated with the "/cc" command.
 * It requires the "jeremyessentials.chatclear" permission to be executed and can only be run from the console.
 * <p>
 * The implementation of the executeCommand method clears the chat by sending empty messages to all players for 100 times.
 * After clearing the chat, a message is broadcasted indicating that the chat has been cleared by the command executor.
 * <p>
 * The suggestTabCompletion method returns an empty list, as there are no tab completions provided for this command.
 */
@Command(
        command = "/cc",
        permission = "jeremyessentials.chatclear",
        description = "This command clears the chat",
        isConsoleCommand = true,
        isAdminCommand = true
)
public class ChatClearCommand extends JeremyExecuter {

    @Override
    @Deprecated
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {

        for (int i = 0; i < 150; i++) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("");
            }
        }

        Bukkit.broadcastMessage(JeremyEssentials.pre + "Chat has been cleared by " + (player != null ? player.getName() : "console") + ".");

        return true;
    }

    @Override public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args)
    {
        return Collections.emptyList();
    }
}