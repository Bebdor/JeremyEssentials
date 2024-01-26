package de.devlucas.jeremyessentials.commands.user.tpa;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;


@Command(
        command = "tpaccept",
        permission = "essentials.tpa",
        description = "Accept a TPA request",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class TpacceptCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, org.bukkit.command.Command command, String[] args) {

        if (args.length == 0)
        {
            Player target = JeremyEssentials.tpa.get(player);

            if (target == null)
            {
                player.sendMessage(JeremyEssentials.pre + "You have not received any tpa requests.");
                return false;
            }

            target.teleport(player.getLocation());


            player.sendMessage(JeremyEssentials.pre + "Successfully teleported " + target.getName() + " to you.");
            target.sendMessage(JeremyEssentials.pre + "Successfully teleported to " + player.getName() + "!");
            JeremyEssentials.tpa.remove(player);


        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }
}
