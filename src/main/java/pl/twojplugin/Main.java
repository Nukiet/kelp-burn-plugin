package pl.twojplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {

        if (event.getBlock().getType() != Material.DRIED_KELP_BLOCK) return;

        Location loc = event.getBlock().getLocation();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.getWorld().equals(loc.getWorld())) continue;

            if (player.getLocation().distance(loc) <= 4) {
                player.addPotionEffect(new PotionEffect(
                        PotionEffectType.CONFUSION,
                        200,
                        0
                ));
            }
        }
    }
}
