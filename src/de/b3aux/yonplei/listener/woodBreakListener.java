package de.b3aux.yonplei.listener;

import de.b3aux.yonplei.commands.diaaxtCMD;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class woodBreakListener implements Listener {

    @EventHandler
    public void onWood(BlockBreakEvent e) {

        Player p = e.getPlayer();

        if (p.hasPermission("yonplei.woodpacker")) {

            if (p.getItemInHand().getType() == Material.DIAMOND_AXE) {

                if (diaaxtCMD.diaaxt.contains(p)) {

                    if (e.getBlock().getType() == Material.ACACIA_LOG || e.getBlock().getType() == Material.BIRCH_LOG || e.getBlock().getType() == Material.DARK_OAK_LOG ||
                            e.getBlock().getType() == Material.DARK_OAK_LOG || e.getBlock().getType() == Material.JUNGLE_LOG || e.getBlock().getType() == Material.OAK_LOG ||
                            e.getBlock().getType() == Material.SPRUCE_LOG || e.getBlock().getType() == Material.STRIPPED_ACACIA_LOG ||
                            e.getBlock().getType() == Material.STRIPPED_BIRCH_LOG || e.getBlock().getType() == Material.STRIPPED_DARK_OAK_LOG || e.getBlock().getType() == Material.STRIPPED_JUNGLE_LOG ||
                            e.getBlock().getType() == Material.STRIPPED_OAK_LOG || e.getBlock().getType() == Material.STRIPPED_SPRUCE_LOG) {

                        e.setCancelled(true);

                        boolean inWood = false;

                        int count = 0;

                        for (int i = -13; i <= 13; i++) {

                            Location loc = e.getBlock().getLocation().add(0, i, 0);

                            if (loc.getBlock().getType() == Material.ACACIA_LOG || loc.getBlock().getType() == Material.BIRCH_LOG || loc.getBlock().getType() == Material.DARK_OAK_LOG ||
                                    loc.getBlock().getType() == Material.DARK_OAK_LOG || loc.getBlock().getType() == Material.JUNGLE_LOG || loc.getBlock().getType() == Material.OAK_LOG ||
                                    loc.getBlock().getType() == Material.SPRUCE_LOG || loc.getBlock().getType() == Material.STRIPPED_ACACIA_LOG || loc.getBlock().getType() == Material.STRIPPED_BIRCH_LOG ||
                                    loc.getBlock().getType() == Material.STRIPPED_DARK_OAK_LOG || loc.getBlock().getType() == Material.STRIPPED_JUNGLE_LOG ||
                                    loc.getBlock().getType() == Material.STRIPPED_OAK_LOG || loc.getBlock().getType() == Material.STRIPPED_SPRUCE_LOG) {

                                count++;

                                if (!inWood) {

                                    inWood = true;

                                }

                                loc.getBlock().breakNaturally();

                            } else {

                                if (count >= 5) {

                                    if (inWood) {

                                        loc.getWorld().spawnFallingBlock(loc.subtract(0, 1, 0), Material.CYAN_WOOL, (byte) 0);

                                        return;

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
