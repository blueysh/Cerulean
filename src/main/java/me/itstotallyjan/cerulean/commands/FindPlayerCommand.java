package me.itstotallyjan.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name="findplayer",description="Finds a player by name.",aliases={"fp","find"},permission="cerulean.findplayer",args={"player"})
public class FindPlayerCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        Player player = Bukkit.getPlayerExact(strings[0]);
        if (player == null) {
            new Message(ChatColor.RED + "Could not find %.".replace("%", strings[0])).send(commandSender);
            return;
        }

        new Message(ChatColor.GREEN + "% is at # in $.".replace("%", strings[0]).replace("#", player.getLocation().toString()).replace("$", player.getLocation().getWorld().getName())).send(commandSender);
    }
}
