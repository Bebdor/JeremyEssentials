package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@main(command = "fly", permission = "essentials.fly", description = "A command that allows the player to fly", isConsoleCommand = false)
public class FlyCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(JeremyEssentials.pre + "Your fly mode has been " + ((player.getAllowFlight()) ? "§aactivated§7." : "§cdeactivated§7."));

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
