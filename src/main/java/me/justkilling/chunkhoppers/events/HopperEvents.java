package me.justkilling.chunkhoppers.events;

import com.sun.tools.javac.jvm.Items;
import me.justkilling.chunkhoppers.Commands.ChunkHopperGive;
import me.justkilling.chunkhoppers.Items.ChunkHopper;
import me.justkilling.chunkhoppers.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static me.justkilling.chunkhoppers.Items.ChunkHopper.hopperLocations;
import static me.justkilling.chunkhoppers.Items.ChunkHopper.itemLocations;


public class HopperEvents implements Listener {
    Main plugin;

    public HopperEvents(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        HopperCheck(); // smol brain

    }

    @EventHandler //im dumb
    public void OnHopperPlace(BlockPlaceEvent event) {

        if (event.getItemInHand().getItemMeta().getLocalizedName().equals(ChunkHopper.localized)) {
            Location particle_location = event.getBlock().getLocation().clone();
            particle_location.add(.5f, .5f, .5f);
            hopperLocations.add(event.getBlock().getLocation());
            ChunkHopperGive.player.getWorld().spawnParticle(Particle.COMPOSTER, particle_location, 25, 0.3f, 0.2f, 0.3f, 0.1f );
            ChunkHopperGive.player.getWorld().playSound(event.getBlock().getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1F, 0.1F);
        }
    }

    @EventHandler
    public void OnHopperBreak(BlockBreakEvent event) {

        if (hopperLocations.contains(event.getBlock().getLocation())) {
            event.setDropItems(false);
            if(ChunkHopperGive.player.getGameMode() == GameMode.CREATIVE ){
                hopperLocations.remove(event.getBlock().getLocation());
                
            }else{
                event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), ChunkHopper.ChunkHopper());
                hopperLocations.remove(event.getBlock().getLocation());
            }


        }


    }
    public void HopperCheck(){
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (Location hopperloc : hopperLocations){

                    Location particle_location = hopperloc.clone();
                    particle_location.add(.5f, .5f, .5f);
                    hopperloc.getWorld().spawnParticle(Particle.FLAME, particle_location, 20, 0.15f, 0.20f, 0.15f, 0.02f);
                    
                }
            }
        } ;
        runnable.runTaskTimer(this.plugin, 200, 20);
    }


}

