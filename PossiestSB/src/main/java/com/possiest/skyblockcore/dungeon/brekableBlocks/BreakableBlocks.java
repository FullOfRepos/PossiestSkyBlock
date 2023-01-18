package com.possiest.skyblockcore.dungeon.brekableBlocks;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

import static com.possiest.skyblockcore.managers.blockReplaceSystem.BlockReplacementEngine.checkBlockReplace;

public class BreakableBlocks implements Listener {
    List<String> resourceWorlds = Arrays.asList("farm_world", "desert_world", "island_world", "world", "lobby");

    @EventHandler
    public void onResourceWorlds(BlockBreakEvent e) {

        if (e.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        checkBlockReplace(
                e,
                Material.IRON_AXE,
                e.getBlock().getType() == Material.DARK_OAK_WOOD && resourceWorlds.contains(e.getBlock().getWorld().getName()),
                true,
                Material.BEDROCK,
                Sound.UI_LOOM_TAKE_RESULT,
                15,
                Material.IRON_INGOT,
                null,
                null
        );
    }
}