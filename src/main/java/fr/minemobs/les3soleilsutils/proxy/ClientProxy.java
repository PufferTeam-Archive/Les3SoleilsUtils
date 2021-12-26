package fr.minemobs.les3soleilsutils.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.minemobs.les3soleilsutils.Les3SoleilsUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.annotation.Nullable;
import java.util.List;

public class ClientProxy extends CommonProxy {

    public static final String FEATURED_SERVER = "minemobs.galaxyfight.fr:25566";
    public static final ResourceLocation STAR_ICON = new ResourceLocation("les3soleilsutils:textures/gui/featured_server.png");

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        ServerList serverList = new ServerList(Minecraft.getMinecraft());
        List<ServerData> serverDatas = Objects.requireNonNull(getServers(serverList));
        ServerData data = new ServerData("Les3Soleils V5.5", FEATURED_SERVER, false);
        if(serverDatas.stream().anyMatch(serverData -> serverData.serverIP.equals(FEATURED_SERVER))) {
            Les3SoleilsUtils.LOGGER.info("The server already exists");
            return;
        }
        serverDatas.add(0, data);
        serverList.saveServerList();
    }

    @SuppressWarnings("unchecked")
    @Nullable
    private List<ServerData> getServers(ServerList list) {
        return ((ServerListMixin) list).getServers();
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
