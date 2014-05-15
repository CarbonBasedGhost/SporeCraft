package com.vapourdrive.sporecraft.utilities;

import net.minecraft.world.World;

public class MainUtilities
{

    /**
     * Spawns a happy villager particle at the given coordinates
     * 
     * @param world
     *            The world instance
     * @param x
     *            x-coord
     * @param y
     *            y-coord
     * @param z
     *            z-coord
     */
    public static void particleSpawn(World world, int x, int y, int z)
    {
        double d0 = (double) ((float) x + world.rand.nextFloat());
        double d1 = (double) ((float) y + world.rand.nextFloat());
        double d2 = (double) ((float) z + world.rand.nextFloat());
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;

        int i1 = world.rand.nextInt(2) * 2 - 1;
        d3 = ((double) world.rand.nextFloat() - 0.5D) * 0.5D;
        d5 = ((double) world.rand.nextFloat() - 0.5D) * 0.5D;

        d3 = (double) (world.rand.nextFloat() * 40.0F * (float) i1);
        d4 = (double) (world.rand.nextFloat() * 40.0F * (float) i1);
        d5 = (double) (world.rand.nextFloat() * 40.0F * (float) i1);

        world.spawnParticle("happyVillager", d1, d2, d0, d4, d5, d3);
        world.spawnParticle("happyVillager", d0, d1, d2, d3, d4, d5);
        world.spawnParticle("happyVillager", d2, d3, d1, d5, d3, d4);
    }

}
