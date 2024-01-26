package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@Command(
        command = "wb",
        permission = "essentials.wb",
        description = "A command that allow the player to open the workbench",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class WorkbenchCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {

        Location location = player.getLocation();
        player.openWorkbench(location, true);
        player.sendMessage(JeremyEssentials.pre + "Successfully opened a workbench");
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }
}
