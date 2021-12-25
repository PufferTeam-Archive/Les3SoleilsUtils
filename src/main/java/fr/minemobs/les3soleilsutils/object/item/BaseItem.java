package fr.minemobs.les3soleilsutils.object.item;

import fr.minemobs.les3soleilsutils.Les3SoleilsUtils;
import net.minecraft.item.Item;

public class BaseItem extends Item {

    public BaseItem(final String name) {
        this.setUnlocalizedName(name);
        this.setTextureName(Les3SoleilsUtils.MODID + ":" + name);
        this.setCreativeTab(Les3SoleilsUtils.creativeTab);
    }
}
