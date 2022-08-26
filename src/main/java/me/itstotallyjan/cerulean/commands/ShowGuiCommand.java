package me.itstotallyjan.cerulean.commands;

import games.negative.framework.command.Command;
import games.negative.framework.command.annotation.CommandInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;

@CommandInfo(name="showgui",description="Shows the specified GUI.",aliases={"gui"},playerOnly=true,permission="cerulean.showgui",args={"gui type"})
public class ShowGuiCommand extends Command {
    public ShowGuiCommand() {
        setTabComplete((commandSender, strings) -> {
            ArrayList<String> c = new ArrayList<>();
            c.add("crafting");
            c.add("enchanting");
            Collections.sort(c);
            return c;
        });
    }

    @Override
    public void onCommand(CommandSender commandSender, String[] strings) {
        Player player = (Player) commandSender;
        switch (strings[0].toLowerCase()) {
            case "crafting":
                player.openWorkbench(null, true);
                break;
            case "enchanting":
                player.openEnchanting(null, true);
                break;
        }
    }
}
