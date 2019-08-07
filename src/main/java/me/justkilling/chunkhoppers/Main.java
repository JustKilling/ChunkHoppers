package me.justkilling.chunkhoppers;

import me.justkilling.chunkhoppers.Commands.ChunkHopperGive;
import me.justkilling.chunkhoppers.events.HopperEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("chunkhopper").setExecutor(new ChunkHopperGive(this));
        new HopperEvents(this);
    }
// Im dumb
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
