package me.WhoKnew.AutoJoin.features.events;

import me.WhoKnew.AutoJoin.Main;
import me.WhoKnew.AutoJoin.handlers.ConfigHandler;
import me.WhoKnew.AutoJoin.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RecievePartyMessageEvent {

    Minecraft mc = Minecraft.getMinecraft();
    EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().thePlayer;

    @SubscribeEvent
    public void onChatMessageReceived(ClientChatReceivedEvent event) {
        if(event.message.toString().toLowerCase().contains("you have 60 seconds to accept. click here to join!")) {
            if(mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.")) {
                mc.thePlayer.addChatMessage(new ChatComponentText(Utils.chat(Main.prefix + "You have recieved a party invite!")));

                String message = event.message.toString();
                String messageArr[] = message.split(" ", 2);
                String firstWord = messageArr[0];
                String restOfMessage = messageArr[1];
                String targetUsername = firstWord.toLowerCase();

                if (ConfigHandler.hasKey("whitelist", targetUsername)) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/party join " + targetUsername);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Utils.chat(Main.prefix + "You have joined &r&4&l" + targetUsername + "&r&a's party. Leaving in 5 seconds!")));

                }
            }
        }
    }
}
