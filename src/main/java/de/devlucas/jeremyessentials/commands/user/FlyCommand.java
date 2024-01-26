package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Command(
        command = "fly",
        permission = "essentials.fly",
        description = "A command that allows the player to fly",
        isConsoleCommand = false,
        isAdminCommand = false
)
public class FlyCommand extends JeremyExecuter {
    @Override
    @Deprecated
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String @NotNull [] args) {

        if (args.length == 0)
        {
            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage(JeremyEssentials.pre + "Your fly mode has been " + ((player.getAllowFlight()) ? ChatColor.GREEN + "activated§7." : ChatColor.RED + "deactivated§7."));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
                return false;
            }

            target.setAllowFlight(!target.getAllowFlight());
            player.sendMessage(JeremyEssentials.pre + "You " + ((target.getAllowFlight()) ? ChatColor.GREEN + "activated§7." : ChatColor.RED + "deactivated§7.") +  " the fly mode of " + target.getName());

        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }
}
