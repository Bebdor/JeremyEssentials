package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@main(command = "globalmute", description = "A command that forces the Player to be quiet.", permission = "jeremyessentials.globalmute", isConsoleCommand = false)

public class GlobalMuteCommand extends JeremyExecuter
{

    public static boolean isChatMuted = false;

    @Override public boolean executeCommand(Player player, Command command, String[] args)
    {
        isChatMuted = !isChatMuted;
        Bukkit.broadcastMessage(JeremyEssentials.pre + "The global chat is now " + (isChatMuted ? "§cmuted§7." : "§aunmuted§7."));

        return true;
    }


    @Override public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args)
    {
        return new ArrayList<>();
    }

}
