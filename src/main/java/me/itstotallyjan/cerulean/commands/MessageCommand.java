package me.itstotallyjan.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import me.itstotallyjan.cerulean.UnsignedChatMessage;
import me.itstotallyjan.cerulean.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name="msg",description="Privately messages another player.",aliases={"w","tell","message","whisper"})
public class MessageCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        if (strings.length >= 1) {
            new Message(ChatColor.RED + "Incorrect usage! /msg <player> <message>").send(commandSender);
            return;
        }
        Player player = Bukkit.getPlayerExact(strings[1]);
        if (player == null) {
            new Message(ChatColor.RED + "Unknown player %.".replace("%", strings[0])).send(commandSender);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String s:strings) {
            sb.append(strings[i]);
        }
        new UnsignedChatMessage(sb.toString(), commandSender).sendPrivately(player);
        Logger.log(Logger.Level.INFO, "% messaged #: $".replace("%", commandSender.getName()).replace("#", player.getName()).replace("$", sb.toString()));
    }
}
