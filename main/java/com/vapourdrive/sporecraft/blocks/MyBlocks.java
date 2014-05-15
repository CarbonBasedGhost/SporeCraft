package com.vapourdrive.sporecraft.blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class MyBlocks
{

    public static Block blockStoneEater;

    public static void init()
    {
        blockStoneEater = new BlockStoneEater();

        GameRegistry.registerBlock(blockStoneEater,
                BlockInfo.STONE_EATER_UNLOCALIZED_NAME);

    }

    public static void registerRecipes()
    {
        // Smelting Recipes

        // Crafting Recipes

    }

}
