package fr.minemobs.les3soleilsutils;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.minemobs.les3soleilsutils.init.ItemInit;
import fr.minemobs.les3soleilsutils.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Les3SoleilsUtils.MODID, version = Les3SoleilsUtils.VERSION)
public class Les3SoleilsUtils {
    public static final String MODID = "les3soleilsutils";
    public static final String VERSION = "@VERSION@";
    public static final CreativeTabs creativeTab = new ModCreativeTab();
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "fr.minemobs.les3soleilsutils.proxy.ClientProxy", serverSide = "fr.minemobs.les3soleilsutils.proxy.ServerProxy")
    private static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @SideOnly(Side.CLIENT)
    public static class ModCreativeTab extends CreativeTabs {

        private ModCreativeTab() {
            super(MODID);
        }

        @Override
        public Item getTabIconItem() {
            return ItemInit.TATER_INGOT;
        }
    }
}
