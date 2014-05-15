package com.vapourdrive.sporecraft.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
    public static File mainConfig;
    public static Configuration config;

    public static void init(String configPath)
    {
        mainConfig = new File(configPath + "main.cfg");

        ConfigMain.init(mainConfig);
    }

}
