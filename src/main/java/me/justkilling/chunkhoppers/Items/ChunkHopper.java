package me.justkilling.chunkhoppers.Items;

import me.justkilling.chunkhoppers.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChunkHopper {
    public static List<Location> hopperLocations = new ArrayList<>();
    public static List<Entity[]> itemLocations = new ArrayList<>();



    public static String localized = "chunkhopper";
    public static ItemStack ChunkHopper(){
        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta meta = hopper.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD+ "" + ChatColor.YELLOW + "Chunk" + ChatColor.GOLD + "Hopper");
        meta.setLocalizedName(localized);
        meta.setLore( Arrays.asList (
                "This is a Chunk hopper!"
        ));
        hopper.setItemMeta(meta);






        return hopper;
    }

}
