package net.minecraft.src;

import net.minecraft.src.GuiAssetButton;

public class GuiClientSettings extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.clear();

        int margin = 5;
        int smallButtonWidth = 10;
        int largeButtonWidth = 60;
        int smallButtonHeight = 10;
        int largeButtonHeight = 14;
        int sidebarWidth = 160;

        int xPos = sidebarWidth - smallButtonWidth - margin;
        int yPos = margin;
        this.buttonList.add(new GuiAssetButton(1, xPos, yPos, smallButtonWidth, smallButtonHeight, "X"));

        int moduleTextY = 20;

        int settingsButtonY = moduleTextY + 5 + largeButtonHeight;
        int settingsButtonX = margin - 3; 

        this.buttonList.add(new GuiAssetButton(2, settingsButtonX + 4, settingsButtonY, largeButtonWidth, largeButtonHeight, "Modules"));
        this.buttonList.add(new GuiAssetButton(3, settingsButtonX + 64, settingsButtonY, largeButtonWidth, largeButtonHeight, "Settings"));

    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
            this.mc.displayGuiScreen(null); 
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //this.drawDefaultBackground();

        int sidebarWidth = 160;
        int sidebarHeight = this.height;

        int sidebarColor = 0x66000000;

        drawRect(0, 0, sidebarWidth, sidebarHeight, sidebarColor);
        drawGradientRect(sidebarWidth, 0, sidebarWidth + 2, sidebarHeight, 0x20000000, 0x00000000);

        this.drawCenteredString(this.fontRenderer, "Modules", sidebarWidth / 2, 10, 0xFFFFFFFF);

        //These are the same integers from above. Didnt wanna seem like boilerplate
        int a = 60;
        int b = 20;
        int c = 10;
        int d = b + 5 + a;
        int lineY = c + a + 2;

        drawRect(0, lineY, sidebarWidth, lineY + 2, 0xFFFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
