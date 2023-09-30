package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@main(command = "cmdspy", permission = "essentials.cmdspy", description = "displays all chat-messages from a player", isConsoleCommand = false)
public class CommandSpyCommand extends JeremyExecuter implements Listener{

    private final HashMap<String, HashSet<String>> cmdSpyMap = new HashMap<>();

    public boolean shouldSpy(String cmdSpyName, String playerCommand) {
        if (!cmdSpyMap.containsKey(cmdSpyName)) return false;
        return !cmdSpyMap.get(cmdSpyName).contains(playerCommand);
    }

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (args.length < 1) {
            String name = player.getName();
            if (cmdSpyMap.containsKey(name)) {
                cmdSpyMap.remove(name);
                player.sendMessage(JeremyEssentials.pre + ChatColor.RED + "Command Spy was been deactivated.");
                return true;
            } else {
                cmdSpyMap.put(name, new HashSet<>());
                player.sendMessage(JeremyEssentials.pre + ChatColor.GREEN + "Command Spy was been activated.");
                return true;
            }
        }
        else if (args.length == 3 && args[0].equalsIgnoreCase("settings")) {
            String name = player.getName();
            if (!cmdSpyMap.containsKey(name)) {
                player.sendMessage(ChatColor.RED + "You can't change your settings until cmdspy is deactivated");
                return true;
            }
            String action = args[1].toLowerCase();
            if (action.equals("remove")) {
                cmdSpyMap.get(name).add(args[2]);
                player.sendMessage(ChatColor.GREEN + "'" + args[2] + "' was removed from your list.");
                return true;
            }
            else if (action.equals("add")) {
                cmdSpyMap.get(name).remove(args[2]);
                player.sendMessage(ChatColor.GREEN + "'" + args[2] + "' was added to your list.");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1) {
            if("settings".startsWith(args[0])) {
                list.add("settings");
            }

            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player.getName().startsWith(args[0])) {
                    list.add(player.getName());
                }
            }
        } else if (args.length == 2 && "settings".equals(args[0])) {
            if("add".startsWith(args[1])) {
                list.add("add");
            }
            if("remove".startsWith(args[1])) {
                list.add("remove");
            }
        }

        return list;
    }

    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
        String playerName = e.getPlayer().getName();

        if (cmdSpyMap.containsKey(playerName)) {
            String command = e.getMessage().split(" ")[0];

            if(shouldSpy(playerName, command)){
                Bukkit.broadcastMessage(ChatColor.GRAY + playerName + " used the command: " + ChatColor.WHITE + e.getMessage());
            }
        }
    }
}