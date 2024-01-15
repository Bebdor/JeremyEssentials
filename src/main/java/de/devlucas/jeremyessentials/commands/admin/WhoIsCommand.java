package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;


@main(
        command = "whois",
        description = "A secret command",
        permission = "essentials.whois",
        isConsoleCommand = false,
        isAdminCommand = true
)

public class WhoIsCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (player.getName().equals("DevLucas") || player.getName().equals("LaDiablo") || player.getName().equals("pamarick"))
        {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null)
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
                return false;
            }
            player.sendMessage(JeremyEssentials.pre + "Information is about " + target.getName() + "!");
            player.sendMessage(JeremyEssentials.pre + "UUID: " + target.getUniqueId());
            player.sendMessage(JeremyEssentials.pre + "IP:" + Objects.requireNonNull(target.getAddress()).toString());
            player.sendMessage(JeremyEssentials.pre + "World: " + target.getWorld().getName());
            player.sendMessage(JeremyEssentials.pre + "X: " + target.getLocation().getBlockX() + " Y: " + target.getLocation().getBlockY() + " Z: " + target.getLocation().getBlockZ());
            player.sendMessage(JeremyEssentials.pre + "Health: " + target.getHealth() + "/" + target.getMaxHealth());
            player.sendMessage(JeremyEssentials.pre + "Food: " + target.getFoodLevel());
            player.sendMessage(JeremyEssentials.pre + "Gamemode: " + target.getGameMode());
            player.sendMessage(JeremyEssentials.pre + "Fly-Mode: " + (target.isFlying() ? "Yes" : "No"));
        }
        else
        {
            player.sendMessage(JeremyEssentials.noRights);
            return false;
        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
