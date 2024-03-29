package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.Command;
import org.jetbrains.annotations.NotNull;

@Command(
        command = "feed",
        permission = "essentials.feed",
        description = "A command that allows the player to set the FoodLevel to 20",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class FeedCommand extends JeremyExecuter
{
    @Override public boolean executeCommand(Player player, org.bukkit.command.Command command, String @NotNull [] args)
    {
        if (args.length == 0)
        {
            player.setFoodLevel(20);
            player.sendMessage(JeremyEssentials.pre + "You are now no longer hungry!");
        }
        else if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
                return false;
            }
            target.setFoodLevel(20);
            player.sendMessage(JeremyEssentials.pre + "The Player " + target.getName() + " is now no longer hungry!");
            target.sendMessage(JeremyEssentials.pre + "You are now no longer hungry!");
        }
        return false;
    }

    @Override public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args)
    {
        return null;
    }
}
