package de.devlucas.jeremyessentials.commands.user.tpa;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;


@main(
        command = "tpa",
        permission = "essentials.tpa",
        description = "Sent a tpa request to a player.",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class TpaCommand extends JeremyExecuter {

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
                return false;
            }

            if (JeremyEssentials.tpa.containsKey(target) && JeremyEssentials.tpa.get(target).equals(player))
            {
                player.sendMessage(JeremyEssentials.pre + "You already sent " + target.getName() + " a tpa request!");
                return false;
            }

            JeremyEssentials.tpa.put(target, player);
            target.sendMessage(JeremyEssentials.pre + ChatColor.GOLD + player.getName() + " §7has sent you a TPA-request!");
            target.sendMessage(JeremyEssentials.pre + "Accept with the command §6/tpaccept§7 or deny with §6/tpdeny§7.");

            player.sendMessage(JeremyEssentials.pre + "Successfully sent a tpa request to " + target.getName() + "!");

        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
