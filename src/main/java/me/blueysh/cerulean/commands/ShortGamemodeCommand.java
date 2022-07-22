package me.blueysh.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;

@CommandInfo(name = "gm", permission = "cerulean.gamemode", playerOnly = true, args = {"gamemode"})
public class ShortGamemodeCommand extends Command {
    public ShortGamemodeCommand() {
        setTabComplete(((commandSender, strings) -> {
            if (strings.length == 0) {
                ArrayList<String> c = new ArrayList<>();
                c.add("adventure");
                c.add("survival");
                c.add("creative");
                c.add("spectator");
                c.add("a");
                c.add("s");
                c.add("c");
                c.add("sp");
                Collections.sort(c);
                return c;
            }
            return null;
        }));
    }
    @Override
    public void onCommand(CommandSender sender, String[] strings) {
        try {
            Player p;
            if (strings.length >= 2) p = Bukkit.getPlayerExact(strings[1]);
            else p = ((Player) sender);
            assert p != null;
            switch (strings[0]) {
                case "adventure":
                case "a":
                    p.setGameMode(GameMode.ADVENTURE);
                    new Message(ChatColor.GREEN + "Set gamemode for % to ADVENTURE.".replace("%", p.getName())).send(sender);
                    break;
                case "survival":
                case "s":
                    p.setGameMode(GameMode.SURVIVAL);
                    new Message(ChatColor.GREEN + "Set gamemode for % to SURVIVAL.".replace("%", p.getName())).send(sender);
                    break;
                case "creative":
                case "c":
                    p.setGameMode(GameMode.CREATIVE);
                    new Message(ChatColor.GREEN + "Set gamemode for % to CREATIVE.".replace("%", p.getName())).send(sender);
                    break;
                case "spectator":
                case "sp":
                    p.setGameMode(GameMode.SPECTATOR);
                    new Message(ChatColor.GREEN + "Set gamemode for % to SPECTATOR.".replace("%", p.getName())).send(sender);
                    break;
                default:
                    new Message(ChatColor.RED + "Invalid gamemode!").send(sender);
            }
        } catch (NullPointerException ex) {
            new Message(ChatColor.RED + "Invalid target!").send(sender);
        }
    }
}