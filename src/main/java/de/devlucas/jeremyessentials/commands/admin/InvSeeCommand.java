package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@main(command = "invsee", permission = "essentials.invsee", description = "A command that allow the player to open a Inventory of other players", isConsoleCommand = false, isAdminCommand = true)

public class InvSeeCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
            player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
            return false;
        }

        if (player == target)
        {
            player.sendMessage(JeremyEssentials.pre + "Just press \"E\"");
            return false;
        }

        player.openInventory(target.getInventory());
        player.sendMessage(JeremyEssentials.pre + "Successfully opened the inventory of " + target.getName() + "!");


        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
