package net.thesyellow.groundedmc.client;

        import com.mojang.blaze3d.systems.RenderSystem;
        import net.minecraft.client.Minecraft;
        import net.thesyellow.groundedmc.GroundedMC;
        import net.minecraft.client.gui.GuiComponent;
        import net.minecraft.client.renderer.GameRenderer;
        import net.minecraft.resources.ResourceLocation;
        import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class StaminaHudOverlay {
    private static final ResourceLocation FULL_STAM = new ResourceLocation(GroundedMC.MOD_ID,
            "textures/stamina/full_stam.png");
    private static final ResourceLocation EMPTY_STAM = new ResourceLocation(GroundedMC.MOD_ID,
            "textures/stamina/empty_stam.png");
    private static final ResourceLocation HUNGER_STAM = new ResourceLocation(GroundedMC.MOD_ID,
            "textures/stamina/hunger_empty_stam.png");

    public static final IGuiOverlay HUD_STAMINA = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;
        float stamPerc = ClientStaminaData.getPlayerStamina();
        float v = (float) (181 * (0.01*stamPerc));
        int stamFillLine = Math.round(v);


        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_STAM);
        GuiComponent.blit(poseStack, x-90, y-29, 0, 0, 181, 5
                    , 181, 5);
        if (Minecraft.getInstance().player.getFoodData().getFoodLevel()<6){
            RenderSystem.setShaderTexture(0, HUNGER_STAM);
            GuiComponent.blit(poseStack, x-90, y-32, 0, 0, 181, 11
                    , 181, 11);}
        //Xpos, Ypos, Idk set it to 1, Idk set it to 0, widthOfTotal, heightOfTotal, widthWithCutoff, heightWithCutoff
        RenderSystem.setShaderTexture(0, FULL_STAM);
        GuiComponent.blit(poseStack, x-90, y-29, 0, 0, stamFillLine, 5
                , 181, 5);
    });
}