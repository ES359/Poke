package me.ES359.Poke;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Debug
{
  public static void log(String msg, boolean useSystemPrint)
  {
    if (Poke.DEBUG) {
      if (useSystemPrint) {
        System.out.println(msg);
      } else {
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
      }
    }
  }
  
  public static void log(String message)
  {
    if (Poke.DEBUG) {
      Bukkit.getServer().getConsoleSender().sendMessage(Flag.LOG + message);
    }
  }
  
  public static void log(Player p, String message)
  {
    if (Poke.DEBUG) {
      p.sendMessage(message);
    }
  }
}
