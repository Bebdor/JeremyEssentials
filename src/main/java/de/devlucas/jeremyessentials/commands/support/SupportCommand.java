package de.devlucas.jeremyessentials.commands.support;

import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Command(
        command = "support",
        permission = "essentials.support",
        description = "A basic support command",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class SupportCommand extends JeremyExecuter {
    private final SupportChatManager supportChatManager = new SupportChatManager();

    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {
        // Make sure the player run this command
        if (player == null) {
            return false;
        }

        // "/support leave" command
        if (args.length == 1 && "leave".equalsIgnoreCase(args[0])) {
            if (supportChatManager.isInSupportChat(player)) {
                Player supporter = supportChatManager.getSupporter(player);
                supporter.sendMessage("Support chat ended.");
                supportChatManager.endSupportChat(player);
            } else {
                player.sendMessage("You're not in any support chat.");
            }
            return true;
        }

        if (args.length == 0) {
            Player supporter = null;
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.hasPermission("essentials.team")) {
                    supporter = onlinePlayer;
                    break;
                }
            }
            if (supporter != null) {
                supportChatManager.startSupportChat(player, supporter);
                player.sendMessage("Support chat started.");
            } else {
                player.sendMessage("No supporter available.");
            }
            return true;
        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 1) {
            suggestions.add("leave");
        }
        return suggestions;
    }
}