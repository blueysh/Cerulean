package me.itstotallyjan.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import me.itstotallyjan.cerulean.Cerulean;
import me.itstotallyjan.cerulean.utils.ConfigPaths;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandInfo(name="rules",description="Displays the rules",playerOnly=true)
public class RulesCommand extends Command {
    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        new Message(ChatColor.translateAlternateColorCodes('&', Cerulean.getPluginConfig().getString(ConfigPaths.Commands.Rules.MESSAGE))).send(commandSender);
    }
}
