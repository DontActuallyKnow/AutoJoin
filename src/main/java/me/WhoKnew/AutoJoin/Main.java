package me.WhoKnew.AutoJoin;

import me.WhoKnew.AutoJoin.features.commands.VersionCommand;
import me.WhoKnew.AutoJoin.features.events.RecievePartyMessageEvent;
import me.WhoKnew.AutoJoin.handlers.ConfigHandler;
import me.WhoKnew.AutoJoin.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {

    Minecraft mc = Minecraft.getMinecraft();

    public static final String MODID = "AUTOJOIN";
    public static final String VERSION = "SNAPSHOT-1.0.5";
    public static final String NAME = "AutoJoin";

    public static String prefix = Utils.chat("&bAutoJoin 7r&c>> &r&a");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Reload the config
        ConfigHandler.reloadConfig();
        //Register Commands
        ClientCommandHandler.instance.registerCommand(new VersionCommand());
        //Register Events
        MinecraftForge.EVENT_BUS.register(new RecievePartyMessageEvent());
    }

}
