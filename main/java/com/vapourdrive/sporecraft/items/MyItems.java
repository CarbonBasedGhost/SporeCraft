package com.vapourdrive.sporecraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MyItems
{

    public static Item chestKey;
    public static Item nanoDiamond;
    public static Item wandSceptre;
    public static Item playerMover;
    public static Item xpSeed;

    public static Item enderSword;
    public static Item enderPick;
    public static Item enderHoe;
    public static Item itemPlanter;

    public static Item enderHelmet;
    public static Item enderLeggings;
    public static Item enderBoots;
    public static Item enderChestplate;

    public static ToolMaterial MAGICENDER_TOOL = EnumHelper.addToolMaterial(
            "MAGICENDER", 3, 600, 8.0F, 2.0F, 20);
    public static ArmorMaterial MAGICENDER_ARMOR = EnumHelper.addArmorMaterial(
            "MAGICENDER", 20, new int[]
            { 3, 6, 5, 3 }, 18);

    public static void init()
    {

    }

    public static void itemRegistry()
    {

    }

    public static void registerRecipes()
    {

    }

}
