package me.blueysh.cerulean.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import net.md_5.bungee.api.ChatColor;

@CommandInfo(playerOnly = true, name = "fly", permission = "cerulean.fly")
public class FlyCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        Player p = (Player) commandSender;

        if (strings.length < 1) {
            // Toggle flight for the sender.
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                new Message(ChatColor.GREEN + "Flight disabled.");
            } else {
                p.setAllowFlight(true);
                new Message(ChatColor.GREEN + "Flight enabled.");
            }
        } else {
            // Toggle flight for the targeted player.
            Player t = Bukkit.getPlayerExact(strings[0]);
            // Tell the sender if there is no such player.
            if (t != null) {
                if (t.getAllowFlight()) {
                    t.setAllowFlight(false);
                    new Message(ChatColor.GREEN + "Flight disabled for player %.".replace("%", t.getName())).send(commandSender);
                } else {
                    t.setAllowFlight(true);
                    new Message(ChatColor.GREEN + "Flight enabled for player %.".replace("%", t.getName())).send(commandSender);
                }
            } else {
                new Message(ChatColor.RED + "Unknown player %.".replace("%", strings[0])).send(commandSender);
                return;
            }
        }
    }
}
