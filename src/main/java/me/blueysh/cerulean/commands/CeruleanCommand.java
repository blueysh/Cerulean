package me.blueysh.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.message.Message;
import me.blueysh.cerulean.Cerulean;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CeruleanCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        new Message(ChatColor.translateAlternateColorCodes('&', "&l&3[Cerulean]&r&3 This server is running Cerulean version " + Cerulean.getVersion())).send(commandSender);
    }
}
