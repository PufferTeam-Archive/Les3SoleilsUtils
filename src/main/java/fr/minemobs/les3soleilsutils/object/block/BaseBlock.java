package fr.minemobs.les3soleilsutils.object.block;

import fr.minemobs.les3soleilsutils.Les3SoleilsUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block {

    protected BaseBlock(String name, Material mat) {
        super(mat);
        this.setBlockName(name);
        this.setBlockTextureName(Les3SoleilsUtils.MODID + ":" + name);
        this.setCreativeTab(Les3SoleilsUtils.creativeTab);
    }
}
