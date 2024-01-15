package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@main(
        command = "wb",
        permission = "essentials.wb",
        description = "A command that allow the player to open the workbench",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class WorkbankCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        Location location = player.getLocation();
        player.openWorkbench(location, true);
        player.sendMessage(JeremyEssentials.pre + "SUccessfully opened a workbench");
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
