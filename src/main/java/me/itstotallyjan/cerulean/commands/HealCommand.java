package me.itstotallyjan.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name="heal",description="Heals you or another player.",permission="cerulean.heal")
public class HealCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        if (!(commandSender instanceof Player)) {
            if (strings.length == 0) {
                new Message(ChatColor.RED + "To use this command as console, you must specify a player.").send(commandSender);
                return;
            }
            Player player = Bukkit.getPlayerExact(strings[0]);
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            new Message(ChatColor.GREEN + "You have healed %.".replace("%", player.getName())).send(commandSender);
            return;
        }
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            new Message(ChatColor.GREEN + "You have been healed.").send(player);
        } else {
            Player target = Bukkit.getPlayerExact(strings[0]);
            if (target == null) {
                new Message(ChatColor.RED + "Could not find %.".replace("%", strings[0])).send(commandSender);
                return;
            }
            target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            new Message(ChatColor.GREEN + "You have healed %.".replace("%", target.getName())).send(commandSender);
        }
    }
}