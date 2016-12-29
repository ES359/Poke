package Commands;

import me.ES359.Poke.Poke;
import me.ES359.Poke.PokeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 12/29/15.
 */
public class PokeCommand extends PokeUtils implements CommandExecutor
{

    private Poke main;

    public PokeCommand(Poke instance)
    {
        this.main = instance;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {
        if(cmd.getName().equalsIgnoreCase("poke"))
        {
            if(!sender.hasPermission("Poke.use"))
            {
                sender.sendMessage(getPermission());
            }else if(args.length < 1)
            {
                sender.sendMessage(getPrefix() +color("&o&9/poke <player> "));
            }else if (args.length > 0) {

                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target == null)
                {
                    sender.sendMessage(color("&cError: &6The player, &2" +args[0]+" &6is not available."));
                    return true;
                }

                String sounds = main.getConfig().getString("Sound-type");
                String msg1 = main.getConfig().getString("Messages.message-sender");
                msg1 = msg1.replace("{name}",sender.getName());
                msg1 = msg1.replace("{targetplayer}",target.getName());

                String msg2 = main.getConfig().getString("Messages.message-receiver");
                msg2 = msg2.replace("{name}",target.getName());
                msg2=msg2.replace("{sender}",sender.getName());


                target.playSound(target.getLocation(),Sound.valueOf(sounds), 1,1);

                target.playSound(target.getLocation(),Sound.AMBIENCE_CAVE,1,1);

                target.sendMessage(getPrefix() + color(msg2));
                sender.sendMessage(getPrefix() + color(msg1));
            }
        }
        return false;
    }
}
