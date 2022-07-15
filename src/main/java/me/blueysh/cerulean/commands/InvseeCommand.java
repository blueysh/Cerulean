package me.blueysh.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import games.negative.framework.message.Message;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;

@CommandInfo(name = "invsee", playerOnly = true, permission = "cerulean.invsee", args = {"type","player"})
public class InvseeCommand extends Command {
    public InvseeCommand() {
        setTabComplete((sender, args) -> {
            if (args.length == 1) {
                ArrayList<String> c = new ArrayList<>();
                c.add("inventory");
                c.add("open-inventory");
                c.add("enderchest");
                return c;
            }
            return null;
        });
    }

    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        Player player = (Player) commandSender;
        Player tPlayer = Bukkit.getPlayerExact(strings[1]);
        switch (strings[0]) {
            case "inventory":
                Inventory i = Bukkit.createInventory(tPlayer, 45);
                i.setContents(tPlayer.getInventory().getContents());
                player.openInventory(i);
                new Message(ChatColor.GREEN + "You are now viewing %'s inventory.".replace("%", tPlayer.getName())).send(player);
                break;
            case "open-inventory":
                if (tPlayer.getOpenInventory() != null) {
                    player.openInventory(tPlayer.getOpenInventory());
                    new Message(ChatColor.GREEN + "You are now viewing %'s open inventory.".replace("%", tPlayer.getName())).send(player);
                } else {
                    new Message(ChatColor.RED + "% has no inventory open.".replace("%", tPlayer.getName())).send(player);
                }
                break;
            case "enderchest":
                player.openInventory(tPlayer.getEnderChest());
                new Message(ChatColor.GREEN + "You are now viewing %'s ender chest.".replace("%", tPlayer.getName())).send(player);
                break;
            default:
                new Message(ChatColor.RED + "Invalid inventory type.").send(player);
        }
    }
}
