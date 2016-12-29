package me.ES359.Poke;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PokeUtils {

    /**
     * Plugin prefix.
     */
    private String prefix = color("&9&lPOKE&r &c&l> ");
    /**
     * Constant permission error.
     */
    private String permission = color(getPrefix() + "&eSorry, but you are not able to use this command.");

    //&bYou may have used incorrect arguments. &cTry using /chat help

    /**
     * Still don't know what this is.
     */
    private String message = "HAI";

    String author = "9c5dd792-dcb3-443b-ac6c-605903231eb2";

    public boolean checkAuthor(UUID uuid)
    {
        return uuid.toString().equals(author);
    }


    /**
     * Gets the set plugin prefix.
     *
     * @return
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Gets pre-defined permission error.
     *
     * @return
     */
    public String getPermission() {
        return this.permission;
    }

    public String getMessage() {
        return this.message;
    }

    public void logToConsole(String msg) {
        Bukkit.getServer().broadcastMessage(msg);
    }


    public String color(String message) {

        return message.replaceAll("&", "§");
    }
}