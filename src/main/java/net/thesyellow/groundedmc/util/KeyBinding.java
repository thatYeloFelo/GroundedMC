package net.thesyellow.groundedmc.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATAGORY_WEAPONACTION = "key.catagory.groundedmc.weaponaction";
    public static final String KEY_HUCK_TOOL = "key.groundedmc.huck_tool";
    public static final String KEY_INCREASESTAM = "key.groundedmc.increasestam";
    public static final String KEY_DECREASESTAM = "key.groundedmc.decreasestam";

    public static final KeyMapping HUCK_KEY = new KeyMapping(KEY_HUCK_TOOL, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATAGORY_WEAPONACTION);
    public static final KeyMapping INCSTAM_KEY = new KeyMapping(KEY_INCREASESTAM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UP, KEY_CATAGORY_WEAPONACTION);
    public static final KeyMapping DECRSTAM_KEY = new KeyMapping(KEY_DECREASESTAM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_DOWN, KEY_CATAGORY_WEAPONACTION);
}
