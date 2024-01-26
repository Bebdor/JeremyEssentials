package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Command(
        command = "msg",
        permission="essentials.msg",
        description = "A command that allows you to chat privately with other players.",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class MessageCommand extends JeremyExecuter {

    @Override
    @Deprecated
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String @NotNull [] args) {
        String msg = "§8[§6MSG§8] §7";
        if(args.length > 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null) {
                if(player.equals(target)) {
                    player.sendMessage(msg + "§bHave the courage to speak to others");
                    return true;
                }
                StringBuilder message = new StringBuilder();
                for(int i = 1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }

                target.sendMessage(msg + "Message from " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + ": " + message);
                player.sendMessage(msg + "Message sent to " + ChatColor.GOLD + target.getName() + ChatColor.GRAY + ": " + message);
            } else {
                player.sendMessage(msg + "§cPlayer not found!");
            }
        } else {
            player.sendMessage(msg + "Usage: /msg <player> <message>");
        }
        return true;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();
        if(args.length == 1) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                    suggestions.add(player.getName());
                }
            }
        }
        return suggestions;
    }
}