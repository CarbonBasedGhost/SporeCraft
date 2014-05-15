package com.vapourdrive.sporecraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.vapourdrive.sporecraft.SporeCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStoneEater extends Block
{

    @SideOnly(Side.CLIENT)
    public static IIcon[] stoneEaterIcon;

    public BlockStoneEater()
    {
        super(Material.rock);

        setCreativeTab(SporeCraft.tabSporeCraft);
        setHardness(1.2F);
        setStepSound(Block.soundTypeStone);
        setBlockName(BlockInfo.STONE_EATER_UNLOCALIZED_NAME);
        setTickRandomly(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        stoneEaterIcon = new IIcon[16];
        for (int i = 0; i < 16; ++i)
        {
            stoneEaterIcon[i] = icon.registerIcon(BlockInfo.TEXTURE_LOCATION
                    + BlockInfo.STONE_EATER_ICON + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return stoneEaterIcon[meta];
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        int l = world.getBlockMetadata(x, y, z);
        int check = 0;

        if (l == 15)
        {
            world.setBlockToAir(x, y, z);
        }

        for (int f = -1; f <= 1; f++)
        {
            for (int g = -1; g <= 1; g++)
            {
                for (int h = -1; h <= 1; h++)
                {
                    if (world.getBlock(x + f, y + g, z + h)
                            .isReplaceableOreGen(world, f + x, y + y, z + z,
                                    Blocks.stone) == false)
                    {
                        check++;
                    }
                }
            }
        }

        if (check >= 26)
        {
            world.setBlockToAir(x, y, z);
        }

        int i = rand.nextInt(3) - 1;
        int j = rand.nextInt(3) - 1;
        int k = rand.nextInt(3) - 1;

        int q = rand.nextInt(5);

        if (q == 0 || q == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, l + 1, 2);
        }

        if (world.getBlock(i + x, j + y, k + z).isReplaceableOreGen(world,
                i + x, j + y, k + z, Blocks.stone)
                || world.getBlock(i + x, j + y, k + z) == Blocks.dirt
                || world.getBlock(i + x, j + y, k + z) == Blocks.gravel)
        {
            world.setBlock(i + x, j + y, k + z, MyBlocks.blockStoneEater, l, 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int meta, float fx, float fy, float fz)
    {
        if (world.isRemote == false)
        {
            System.out.println(world.getBlockMetadata(x, y, z));
        }
        return false;
    }

    @Override
    public boolean isReplaceableOreGen(World world, int x, int y, int z,
            Block target)
    {
        return false;
    }

}
