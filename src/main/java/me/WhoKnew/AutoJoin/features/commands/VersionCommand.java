package me.WhoKnew.AutoJoin.features.commands;

import me.WhoKnew.AutoJoin.Main;
import me.WhoKnew.AutoJoin.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class VersionCommand implements ICommand {
    @Override
    public String getCommandName() {
        return "ajversion";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public List<String> getCommandAliases() {
        ArrayList<String> commandAliases = new ArrayList<String>();
        commandAliases.add("ajv");
        commandAliases.add("autojoinv");
        commandAliases.add("autojoinversion");
        return commandAliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;

        player.addChatMessage(new ChatComponentText(Utils.chat("&bGuildBot &r&c>> &raYou are running v&2" + Main.VERSION)));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
