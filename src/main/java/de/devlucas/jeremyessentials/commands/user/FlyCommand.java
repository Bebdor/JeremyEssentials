package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@main(
        command = "fly",
        permission = "essentials.fly",
        description = "A command that allows the player to fly",
        isConsoleCommand = false,
        isAdminCommand = false
)
public class FlyCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (args.length == 0)
        {
            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage(JeremyEssentials.pre + "Your fly mode has been " + ((player.getAllowFlight()) ? "§aactivated§7." : "§cdeactivated§7."));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
                return false;
            }

            target.setAllowFlight(!target.getAllowFlight());
            player.sendMessage(JeremyEssentials.pre + "You " + ((target.getAllowFlight()) ? "§aactivated§7." : "§cdeactivated§7.") +  " the fly mode of " + target.getName());

        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
