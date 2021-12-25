package fr.minemobs.les3soleilsutils.mixin.client;

import fr.minemobs.les3soleilsutils.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerListEntryNormal.class)
public abstract class ServerListEntryNormalMixin {

    @Shadow @Final private ServerData field_148301_e;

    @Shadow @Final private Minecraft field_148300_d;

    @Inject(method = "drawEntry", at = @At("TAIL"))
    public void drawEntry(int p_148279_1_, int x, int y, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_, CallbackInfo info) {
        if(!field_148301_e.serverIP.equals(ClientProxy.FEATURED_SERVER)) return;
        drawImg(x, y, false, ClientProxy.STAR_ICON);
    }

    private void drawImg(int x, int y, boolean lower, ResourceLocation texture) {
        this.field_148300_d.getTextureManager().bindTexture(texture);
        Gui.func_146110_a(x - 16, lower ? y + 16 : y, 0, 0, 16, 16, 16, 16);
    }
}
