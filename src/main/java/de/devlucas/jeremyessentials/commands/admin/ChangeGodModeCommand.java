package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.Command;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
 * Example usage:
 * /god - toggles god mode for the player who executed the command.
 * /god <player> - toggles god mode for the specified player.
 */
@Command(
        command = "/god",
        permission = "jeremyessentials.god",
        description = "This command toggles god mode",
        isConsoleCommand = false,
        isAdminCommand = true
)
public class ChangeGodModeCommand extends JeremyExecuter {

    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {
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
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String @NotNull [] args) {
        if (args.length == 1) {
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private void toggleGodMode(@NotNull Player player) {
        boolean godMode = !player.isInvulnerable();
        player.setInvulnerable(godMode);
        player.sendMessage(JeremyEssentials.pre + "God mode has been " + (godMode ? "§aenabled" : "§cdisabled") + ".");
    }
}