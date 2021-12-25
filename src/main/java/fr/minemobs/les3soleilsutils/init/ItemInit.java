package fr.minemobs.les3soleilsutils.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.minemobs.les3soleilsutils.object.item.BaseItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInit {

    public static final Map<String, Item> ITEMS = new HashMap<>();

    public static final Item TATER_INGOT = registerItem("tater_ingot");

    private ItemInit() {}

    private static Item registerItem(String name) {
        Item item = new BaseItem(name);
        ITEMS.put(name, item);
        return item;
    }

    public static void registerItems() {
        ITEMS.forEach((s, item) -> GameRegistry.registerItem(item, s));
    }
}
