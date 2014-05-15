package com.vapourdrive.sporecraft.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigMain
{

    public static Configuration config;

    public static void init(File configFile)
    {
        config = new Configuration(configFile);

        config.load();
        System.out.println("[SporeCraft]Generating config for Sporecraft");

        config.save();
    }
}
