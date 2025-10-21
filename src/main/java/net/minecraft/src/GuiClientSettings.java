package net.minecraft.src;

import net.minecraft.src.GuiMainButton;

public class GuiClientSettings extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.clear();

        int margin = 5;
        int buttonWidth = 155;
        int buttonHeight = 20;

        int xPos = margin;
        int yPos = this.height - buttonHeight - margin;

        this.buttonList.add(new GuiButton(1, xPos, yPos, buttonWidth, buttonHeight, "Close"));

    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
            this.mc.displayGuiScreen(null); // close settings screen
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //this.drawDefaultBackground();

        int sidebarWidth = 160;
        int sidebarHeight = this.height;

        //Note to self: ARGB format
        int sidebarColor = 0x66000000;

        // Left Sidebar
        drawRect(0, 0, sidebarWidth, sidebarHeight, sidebarColor);
        drawGradientRect(sidebarWidth, 0, sidebarWidth + 2, sidebarHeight, 0x20000000, 0x00000000);

        this.drawCenteredString(this.fontRenderer, "Modules", sidebarWidth / 2, 10, 0xFFFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
