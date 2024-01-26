package de.devlucas.jeremyessentials.commands.admin;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


/**
 *  A command class for changing the player's gamemode.
 */
@Command(
        command = "gamemode",
        permission = "essentials.gamemode",
        description = "Changes the gamemode",
        isConsoleCommand = false,
        isAdminCommand = true
)

public class ChangeGamemodeCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(@NotNull Player player, @NotNull org.bukkit.command.Command command, @NotNull String[] args) {

        if (args.length == 0) {
            player.sendMessage(JeremyEssentials.pre + "Please specify a game mode.");
            return false;
        }

        if (args.length == 1)
        {
            String arg = args[0];
            GameMode mode;
            switch (arg) {
                case "0":
                case "s":
                case "survival":
                    mode = GameMode.SURVIVAL;
                    break;
                case "1":
                case "c":
                case "creative":
                    mode = GameMode.CREATIVE;
                    break;
                case "2":
                case "a":
                case "adventure":
                    mode = GameMode.ADVENTURE;
                    break;
                case "3":
                case "sp":
                case "spectator":
                    mode = GameMode.SPECTATOR;
                    break;
                default:
                    player.sendMessage(JeremyEssentials.pre + "§cInvalid game mode.");
                    return false;
            }


            player.setGameMode(mode);
            player.sendMessage(JeremyEssentials.pre + "Game mode changed to §6" + mode.name().toLowerCase() + "§7.");
        }
        if (args.length == 2)
        {
            Player target = Bukkit.getPlayer(args[1]);
            String arg = args[0];
            GameMode mode;
            switch (arg) {
                case "0":
                case "s":
                case "survival":
                    mode = GameMode.SURVIVAL;
                    break;
                case "1":
                case "c":
                case "creative":
                    mode = GameMode.CREATIVE;
                    break;
                case "2":
                case "a":
                case "adventure":
                    mode = GameMode.ADVENTURE;
                    break;
                case "3":
                case "sp":
                case "spectator":
                    mode = GameMode.SPECTATOR;
                    break;
                default:
                    player.sendMessage(JeremyEssentials.pre + "§cInvalid game mode.");
                    return false;
            }


            assert target != null;
            target.setGameMode(mode);
            player.sendMessage(JeremyEssentials.pre + "Game mode of " + target.getName() + " changed to §6 " + mode.name().toLowerCase() + "§7.");
        }
        return true;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1) {
            String[] gamemodes = {"0", "1", "2", "3", "c", "s", "a", "sp", "creative", "survival", "adventure", "spectator"};
            for (String mode : gamemodes) {
                if(mode.startsWith(args[0])) {
                    list.add(mode);
                }
            }
        }
        else if (args.length == 2) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player.getName().startsWith(args[1])) {
                    list.add(player.getName());
                }
            }
        }

        return list;
    }
}