package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class KickCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (args.length == 1)
        {
            player.sendMessage(JeremyEssentials.pre + "Please enter a reason.");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null)
        {
            player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
            return false;
        }

        StringBuilder message = new StringBuilder();
        for(int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }


        String header = "§7------- " + JeremyEssentials.pre + "-------";
        String body = "You have been kicked from this server.\nReason: " + message;
        String footer = header;

        String kickMessage = header+body+footer;

        target.kickPlayer(kickMessage);


        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
