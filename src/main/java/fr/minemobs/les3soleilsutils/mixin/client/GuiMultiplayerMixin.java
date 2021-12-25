package fr.minemobs.les3soleilsutils.mixin.client;

import fr.minemobs.les3soleilsutils.proxy.ClientProxy;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiMultiplayer.class)
public abstract class GuiMultiplayerMixin {

    @Shadow private ServerSelectionList field_146803_h;

    /**Join Button*/
    @Shadow private GuiButton field_146809_s;

    /**Delete Button*/
    @Shadow private GuiButton field_146808_t;

    /**Edit Button*/
    @Shadow private GuiButton field_146810_r;

    /**
     * @author MineMobs
     * @param index Index of the server in the list
     * @reason Because I'm too dumb to find a way to do it with the mixin without using the overwritten method
     */
    @Overwrite
    public void func_146790_a(int index) {
        this.field_146803_h.func_148192_c(index);
        GuiListExtended.IGuiListEntry iguilistentry = index < 0 ? null : this.field_146803_h.getListEntry(index);
        this.field_146809_s.enabled = false;
        this.field_146810_r.enabled = false;
        this.field_146808_t.enabled = false;

        if (iguilistentry != null && !(iguilistentry instanceof ServerListEntryLanScan)) {
            this.field_146809_s.enabled = true;

            if (iguilistentry instanceof ServerListEntryNormal) {
                if(((ServerListEntryNormal) iguilistentry).func_148296_a().serverIP.equals(ClientProxy.FEATURED_SERVER)) return;
                this.field_146810_r.enabled = true;
                this.field_146808_t.enabled = true;
            }
        }
    }
}
