package fr.minemobs.les3soleilsutils.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class BlockInit {

    public static final Map<String, Block> BLOCKS = new HashMap<>();

    private BlockInit() {}

    public static Block registerBlock(String name, Block block) {
        BLOCKS.put(name, block);
        return block;
    }

    public static void registerBlocks() {
        BLOCKS.forEach((s, block) -> GameRegistry.registerBlock(block, s));
    }

}
