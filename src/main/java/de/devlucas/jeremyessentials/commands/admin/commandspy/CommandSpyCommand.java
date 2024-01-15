package de.devlucas.jeremyessentials.commands.admin.commandspy;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@main(
        command = "cmdspy",
        permission = "essentials.cmdspy",
        description = "displays all chat-messages from a player",
        isConsoleCommand = false,
        isAdminCommand = true
)

public class CommandSpyCommand extends JeremyExecuter implements Listener{


    @Override
    public boolean executeCommand(Player player, Command command, String @NotNull [] args) {

        if (JeremyEssentials.commandspyList.contains(player))
        {
            JeremyEssentials.commandspyList.remove(player);
            player.sendMessage(JeremyEssentials.pre + "Commandspy enabled.\nYou can now see all player commands like the console");
            }
        else
        {
            JeremyEssentials.commandspyList.add(player);
            player.sendMessage(JeremyEssentials.pre + "Commandspy disabled.");
        }


        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String @NotNull [] args) {
        List<String> list = new ArrayList<>();

        return list;
    }
}