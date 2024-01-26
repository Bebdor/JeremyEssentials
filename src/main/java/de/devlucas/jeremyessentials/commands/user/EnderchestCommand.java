package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Command(
        command = "ec",
        permission = "essentials.ec",
        description = "A command that allow the player to open the enderchest of other players",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class EnderchestCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String @NotNull [] args) {

        if (args.length == 0)
        {
            player.openInventory(player.getEnderChest());
            player.sendMessage(JeremyEssentials.pre + "Successfully opened your enderchest!");
            return false;
        } else if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            target = (target == null ? (Player) Bukkit.getOfflinePlayer(args[0]) : target);

            player.openInventory(target.getEnderChest());
            player.sendMessage(JeremyEssentials.pre + "Successfully opened the enderchest! of " + target.getName());
            return false;
        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }
}
