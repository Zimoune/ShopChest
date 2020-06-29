package de.epiceric.shopchest.listeners;

<<<<<<< HEAD
import de.epiceric.shopchest.ShopChest;
import de.epiceric.shopchest.config.Config;
=======
import java.util.ArrayList;

import org.bukkit.Material;
>>>>>>> upstream/master
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

import de.epiceric.shopchest.ShopChest;

public class BlockExplodeListener implements Listener {

    private ShopChest plugin;

    public BlockExplodeListener(ShopChest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e) {
        ArrayList<Block> bl = new ArrayList<>(e.blockList());
        for (Block b : bl) {
            if (Config.allowedContainerType.contains(b.getType())) {
                if (plugin.getShopUtils().isShop(b.getLocation())) e.blockList().remove(b);
            }
        }
    }

}
