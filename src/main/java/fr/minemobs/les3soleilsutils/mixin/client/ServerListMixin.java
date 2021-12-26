package fr.minemobs.les3soleilsutils.mixin.client;

import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ServerList.class)
public interface ServerListMixin {

    @Accessor("servers")
    List getServers();

}
