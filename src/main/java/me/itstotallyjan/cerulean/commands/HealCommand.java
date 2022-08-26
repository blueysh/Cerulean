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
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
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