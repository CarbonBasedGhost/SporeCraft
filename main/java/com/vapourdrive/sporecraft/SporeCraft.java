package com.vapourdrive.sporecraft;

import com.vapourdrive.sporecraft.blocks.MyBlocks;
import com.vapourdrive.sporecraft.blocks.OreDictionaryRegistry;
import com.vapourdrive.sporecraft.config.ConfigHandler;
import com.vapourdrive.sporecraft.creativetab.CreativeTabEP;
import com.vapourdrive.sporecraft.event.FMLEventHooks;
import com.vapourdrive.sporecraft.event.ForgeEventHooks;
import com.vapourdrive.sporecraft.items.MyItems;
import com.vapourdrive.sporecraft.materials.MyMaterials;
import com.vapourdrive.sporecraft.proxies.CommonProxy;
import com.vapourdrive.sporecraft.world.WorldInfo;
import com.vapourdrive.sporecraft.world.WorldStoneGeneration;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class SporeCraft
{

    @Instance(ModInfo.ID)
    public static SporeCraft instance;

    @SidedProxy(clientSide = "com.vapourdrive.sporecraft.proxies.ClientProxy", serverSide = "com.vapourdrive.sporecraft.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabSporeCraft;
    public static String configPath;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {

        configPath = event.getModConfigurationDirectory() + "/sporecraft/";
        tabSporeCraft = new CreativeTabEP(CreativeTabs.getNextID(),
                "tabSporeCraft");

        MinecraftForge.EVENT_BUS.register(new ForgeEventHooks());
        FMLCommonHandler.instance().bus().register(new FMLEventHooks());

        ConfigHandler.init(configPath);
        proxy.initSounds();
        proxy.initRenderers();

        MyMaterials.init();
        MyItems.init();
        MyItems.itemRegistry();
        MyBlocks.init();
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {

        MyItems.registerRecipes();

        MyBlocks.registerRecipes();
        OreDictionaryRegistry.init();

        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
                new WeightedRandomChestContent(new ItemStack(MyItems.chestKey),
                        1, 1, 30));

        if (WorldInfo.GENERATE_WORLD == false)
        {
            new WorldStoneGeneration();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
