package net.minecraft.src;

public class GuiClientSettings extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 + 40, "Close"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
            this.mc.displayGuiScreen(null); // close settings screen
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Draw panorama / background blur behind it
        this.drawDefaultBackground();

        // Sidebar dimensions
        int sidebarWidth = 120;
        int sidebarHeight = this.height;

        // White with slight transparency (ARGB)
        int sidebarColor = 0x4DFFFFFF; // 0xAARRGGBB → 0x80 = 50% opacity

        // Draw sidebar on the left
        drawRect(0, 0, sidebarWidth, sidebarHeight, sidebarColor);

        // Optional: Add a small shadow divider to make it pop
        drawGradientRect(sidebarWidth, 0, sidebarWidth + 2, sidebarHeight, 0x20000000, 0x00000000);

        // Draw your sidebar title text
        this.drawCenteredString(this.fontRenderer, "Settings", sidebarWidth / 2, 10, 0xFFFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
