package net.novelmc.novelmc.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Title implements Displayable
{

    ARCHITECT("an", "Architect", "ARCHITECT", ChatColor.DARK_PURPLE),
    DEVELOPER("a", "Developer", "DEV", ChatColor.BLUE);

    private final String determiner;
    @Getter
    private final String name;
    @Getter
    private final String tag;
    @Getter
    private final ChatColor color;

    Title(String determiner, String name, String tag, ChatColor color)
    {
        this.determiner = determiner;
        this.name = name;
        this.color = color;
        this.tag = color + tag + " " + color;
    }

    public String getLoginMessage()
    {
        return determiner + " " + color + name;
    }
}
