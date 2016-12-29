package me.ES359.Poke;

import Commands.PokeCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ES359 on 12/29/15.
 */
public class Poke extends JavaPlugin {

    public PluginDescriptionFile pdfFile = this.getDescription();

    public void onEnable() {
        getCommand("Poke").setExecutor(new PokeCommand(this));

        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void onDisable() {
    }


    public static boolean DEBUG = false;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {
        if(cmd.getName().equalsIgnoreCase("pokeadmin"))
        {
          if(!sender.hasPermission("Poke.admin"))
          {
              sender.sendMessage(ChatColor.RED + "You don't have permission for this...");
          }else if(args.length == 0)
          {
              sender.sendMessage(ChatColor.RED +"Usage: /pokeadmin help");
          }else if(args.length >0)
          {
              switch (args[0]) {
                  case "rl":
                  case "reload":
                      if (!sender.hasPermission("Poke.reload")) {
                          sender.sendMessage(utils.getPermission());
                      } else {
                          reloadConfig();
                          sender.sendMessage(utils.getPrefix() + utils.color("&7Configuration has been &2&oreloaded&7!"));
                      }
                      break;
                  case "sounds":
                      sender.sendMessage(utils.color("&2========== &7[" + utils.getPrefix() + "&7] &2=========="));
                      sender.sendMessage(utils.color("&6This contains a complete list of sounds that can be used!"));
                      sender.sendMessage(utils.color("&cLink: &a&lhttps://gist.github.com/ES359/7aa8da5dbf88496e4098"));
                      break;
                  case "help":
                  case "?":
                      sender.sendMessage(utils.color("&2========== &7[" + utils.getPrefix() + "&7] &2=========="));
                      sender.sendMessage(utils.color("&7[&9 " + pdfFile.getName() + "&7] &6Created by, &b" +pdfFile.getAuthors() + "&6."));
                      sender.sendMessage(utils.color("&2" + pdfFile.getDescription() + "&2."));
                      sender.sendMessage(utils.color("&9/poke <&2player&9>\n&9/pokeadmin reload\n&9/pokeadmin sounds\n&9/pokeadmin help"));
                      break;
              }
          }
        }
        return true;
    }

    PokeUtils utils = new PokeUtils();
}
