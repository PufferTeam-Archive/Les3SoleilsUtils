package fr.minemobs.les3soleilsutils.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.minemobs.les3soleilsutils.init.BlockInit;
import fr.minemobs.les3soleilsutils.init.ItemInit;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        BlockInit.registerBlocks();
        ItemInit.registerItems();
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}
}
