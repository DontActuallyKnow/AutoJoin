package me.WhoKnew.AutoJoin.features.events;

import me.WhoKnew.AutoJoin.Main;
import me.WhoKnew.AutoJoin.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RecievePartyMessageEvent {

    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onChatMessageReceived(ClientChatReceivedEvent event) {
        if(event.message.toString().toLowerCase().contains("you have 60 seconds to accept. click here to join!")) {
            if(mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.")) {
                mc.thePlayer.addChatMessage(new ChatComponentText(Utils.chat(Main.prefix + "You have recieved a party invite!")));
            }
        }
    }

}
