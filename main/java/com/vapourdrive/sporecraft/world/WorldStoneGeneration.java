package com.vapourdrive.sporecraft.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldStoneGeneration implements IWorldGenerator
{

    public WorldStoneGeneration()
    {
        GameRegistry.registerWorldGenerator(this, 0);
    }

    /*
     * private void generateStandardOre(Random rand, int chunkX, int chunkZ,
     * World world, int iterations, WorldGenerator gen, int lowestY, int
     * highestY) { for (int i = 0; i < iterations; i++) { int x = chunkX * 16 +
     * rand.nextInt(16); int y = rand.nextInt(highestY - lowestY) + lowestY; int
     * z = chunkZ * 16 + rand.nextInt(16);
     * 
     * gen.generate(world, rand, x, y, z); } }
     */

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
        case -1:
            if (WorldInfo.GENERATE_NANODIAMOND == true)
            {
            }
            break;

        case 0:
            break;

        case 1:
            break;

        default:
            break;
        }
    }

}
