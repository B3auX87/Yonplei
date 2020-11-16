package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class pecCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("yonplei.penderchest")) {

            if (cmd.getName().equalsIgnoreCase("pec")) {

                if (args.length == 0) {

                    p.sendMessage(Main.prefix + "§6/pec §7<Name>");

                }

                if (args.length == 1) {

                    Player t = Bukkit.getPlayer(args[0]);

                    if (t == null) {

                        p.sendMessage(Main.playerNotOnline);

                        return true;

                    }

                    Inventory inv = Bukkit.createInventory(null, 54, "§7>> §9§lSpieler§7-§9§lEC");

                    inv.setItem(0, t.getInventory().getHelmet());
                    inv.setItem(2, t.getInventory().getChestplate());
                    inv.setItem(6, t.getInventory().getLeggings());
                    inv.setItem(8, t.getInventory().getBoots());

                    List<String> lore = new ArrayList<String>();

                    for (PotionEffect e : t.getActivePotionEffects()) {

                        lore.add(e.toString());

                    }

                    ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                    SkullMeta sk = (SkullMeta) skull.getItemMeta();
                    sk.setOwner(t.getName());
                    sk.setDisplayName("§eEnderchest von §7" + t.getName());
                    skull.setItemMeta(sk);

                    ItemStack Potion = new ItemStack(Material.POTION, 1);
                    PotionMeta pt = (PotionMeta) Potion.getItemMeta();
                    pt.addEnchant(Enchantment.DURABILITY, 0, true);
                    pt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    pt.setDisplayName("§aEffekte von §7" + t.getName());
                    pt.setLore(lore);
                    Potion.setItemMeta(pt);

                    inv.setItem(4, skull);
                    inv.setItem(9, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(10, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(11, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(12, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(13, Potion);
                    inv.setItem(14, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(15, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(16, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));
                    inv.setItem(17, GiveItem(Material.BLACK_STAINED_GLASS_PANE, "§3", 1));

                    int a = 18;

                    for (int i = 0; i < t.getEnderChest().getStorageContents().length; i++) {

                        inv.setItem(a, t.getEnderChest().getItem(i));

                        a++;

                    }

                    Main.open.put(p, t);

                    p.openInventory(inv);

                }
            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }

    public static ItemStack GiveItem(Material mat, String Name, int amo) {
        ItemStack is = new ItemStack(mat, amo);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Name);
        is.setItemMeta(im);
        return is;
    }
}
