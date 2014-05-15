package com.vapourdrive.sporecraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabEP extends CreativeTabs
{

    public CreativeTabEP(int position, String tabID)
    {
        super(position, tabID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTabLabel()
    {
        return "Sporecraft";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return "SporeCraft";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Items.ender_eye;
    }

}
