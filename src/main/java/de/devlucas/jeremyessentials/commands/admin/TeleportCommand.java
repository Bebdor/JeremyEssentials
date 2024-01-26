package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Command(command = "tp", permission = "essentials.tp", description = "A command that allows the player to teleport to another player or to coords", isConsoleCommand = false, isAdminCommand = true)
public class TeleportCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {

        if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null)
            {
                player.teleport(target);
                player.sendMessage(JeremyEssentials.pre + "Successfully teleported to " + target.getName());
            }
            else
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
            }
        }
        else if (args.length == 3)
        {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
                player.sendMessage(JeremyEssentials.pre + "Successfully teleported to " + x + " " + y + " " + z);
                return true;
            } catch (NumberFormatException exception) {
                System.out.println("Error: " + exception);
            }
        }
        else if (args.length == 2)
        {
            Player player1 = Bukkit.getPlayer(args[0]);
            Player player2 = Bukkit.getPlayer(args[1]);

            if (player1 != null && player2 != null)
            {
                player1.teleport(player2);
                player.sendMessage(JeremyEssentials.pre + "Successfully teleported " + player1 + " to " + player2);
                return true;
            }
            else
            {
                player.sendMessage(JeremyEssentials.pre + "Player not found!");
            }
        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Bukkit.getServer().getOnlinePlayers().stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
