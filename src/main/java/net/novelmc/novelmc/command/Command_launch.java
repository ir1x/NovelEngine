package net.novelmc.novelmc.command;

import net.novelmc.novelmc.NovelMC;
import net.novelmc.novelmc.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandParameters(description = "Launchs them up, strikes them down", usage = "/<command> <player>", source = SourceType.BOTH, rank = Rank.MANAGER)
public class Command_launch
{

    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 1)
        {
            return false;
        }

        Player player = Bukkit.getPlayer(args[0]);
        if (player == null)
        {
            sender.sendMessage(ChatColor.RED + "Cannot find that player!");
            return true;
        }

        player.setGameMode(GameMode.SURVIVAL);

        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 40, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 4; i++)
                {
                    player.getWorld().strikeLightning(player.getLocation());
                }
                player.getWorld().createExplosion(player.getLocation(), 8F, true);
            }
        }.runTaskLater(NovelMC.plugin, 2L * 20L);
        return true;
    }
}
