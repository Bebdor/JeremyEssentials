package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.utils.PermissionCheckingCommand;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@main(command = "msg", permission="essentials.msg", description = "A command that allows you to chat privately with other players.", isConsoleCommand = false)
public class MsgCommand extends PermissionCheckingCommand {

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        String msg = "§8[§6Msg§8] §7";
        if(args.length > 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null) {
                if(player.equals(target)) {
                    player.sendMessage(msg + "§bTrau dich doch auch andere anzusprechen");
                    return true;
                }
                StringBuilder message = new StringBuilder();
                for(int i = 1; i < args.length; i++) {
                    message.append(args[i]).append(" ");
                }

                target.sendMessage(msg + "Message from " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + ": " + message.toString());
                player.sendMessage(msg + "Message sent to " + ChatColor.GOLD + target.getName() + ChatColor.GRAY + ": " + message.toString());
            } else {
                player.sendMessage(msg + "§cPlayer not found!");
            }
        } else {
            player.sendMessage(msg + "Usage: /msg <player> <message>");
        }
        return true;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
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