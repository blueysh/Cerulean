package me.itstotallyjan.cerulean.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;

import java.lang.NumberFormatException;

@CommandInfo(name = "damage", args = {"player","amount"}, permission = "cerulean.damage", description = "Damages a player by the provided amount of health points.")
public class DamageCommand extends Command {
    @Override
    public void onCommand(CommandSender sender, String[] strings) {
        Player player = Bukkit.getPlayerExact(strings[0]);
        try {
            int amount = Integer.parseInt(strings[1]);
            player.setHealth(player.getHealth() - amount);
            new Message(ChatColor.GREEN + "Dealt % damage to #.".replace("%", amount + "").replace("#", player.getName())).send(sender);
        } catch (NumberFormatException e) {
            new Message(ChatColor.RED + "The amount of health points to deal must be a number.").send(sender);
        }
    }
}
