package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.main;
import de.devlucas.jeremyessentials.utils.PermissionCheckingCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The ChangeGodModeCommand class is responsible for toggling god mode for a player.
 * <p>
 * This command allows players to toggle their own god mode or the god mode of another player.
 * <p>
 * Usage: /god [<player>]
 * - If no player is specified, the command will toggle the god mode of the player who executed the command.
 * - If a player is specified, the command will toggle the god mode of the specified player.
 * <p>
 * Permissions:
 * - jeremyessentials.god - Allows access to the /god command.
 * <p>
 * Example usage:
 * /god - toggles god mode for the player who executed the command.
 * /god <player> - toggles god mode for the specified player.
 */
@main(
        command = "/god",
        permission = "jeremyessentials.god",
        description = "This command toggles god mode",
        isConsoleCommand = false
)
public class ChangeGodModeCommand extends PermissionCheckingCommand {

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        if (args.length == 0) {
            toggleGodMode(player);
        } else if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayerExact(args[0]);
            if (targetPlayer != null) {
                toggleGodMode(targetPlayer);
            } else {
                player.sendMessage(JeremyEssentials.playerNotFound(args[0]));
            }
        }
        return true;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private void toggleGodMode(Player player) {
        boolean godMode = !player.isInvulnerable();
        player.setInvulnerable(godMode);
        player.sendMessage(JeremyEssentials.pre + "God mode has been " + (godMode ? "§aenabled" : "§cdisabled") + ".");
    }
}