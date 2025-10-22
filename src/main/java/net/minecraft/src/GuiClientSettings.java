package net.minecraft.src;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.src.GuiAssetButton;

public class GuiClientSettings extends GuiScreen {

    private List<Module> modules = new ArrayList<>();
    private int sidebarWidth = 200;
    private int margin = 5;

    @Override
    public void initGui() {
        this.buttonList.clear();

        // Sample modules, rembember that these DONT work right now, they are just for display
        modules.add(new Module("Fullbright", false));
        modules.add(new Module("FPS", false));
        modules.add(new Module("CPS", false));
        modules.add(new Module("Potion UI", false));
        modules.add(new Module("Armor Status", false));
        modules.add(new Module("Time", false));
        modules.add(new Module("Coordinates", false));
        modules.add(new Module("Keystrokes", false));
        modules.add(new Module("No Rain", false));
        modules.add(new Module("Clear Chat", false));
        modules.add(new Module("Speed", false));
        modules.add(new Module("Block Outline", false));

        int smallButtonWidth = 10;
        int smallButtonHeight = 10;
        int xPos = sidebarWidth - smallButtonWidth - margin;
        int yPos = margin;

        this.buttonList.add(new GuiAssetButton(1, xPos, yPos, smallButtonWidth, smallButtonHeight, "X"));
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        int xButtonWidth = 10;
        int xButtonHeight = 10;
        int xButtonX = sidebarWidth - xButtonWidth - margin;
        int xButtonY = margin;

        if (mouseX >= xButtonX && mouseX <= xButtonX + xButtonWidth &&
            mouseY >= xButtonY && mouseY <= xButtonY + xButtonHeight) {
            this.mc.displayGuiScreen(null); //
            return; 
        }

        int startY = 50;
        int spacing = 22;
        int toggleWidth = 30;
        int toggleHeight = 12;
        int toggleX = sidebarWidth - toggleWidth - margin;

        /*
         * Handles the  space where the ON/OFF toggles are drawn and toggles the module state when clicked
         */
        for (int i = 0; i < modules.size(); i++) {
            Module m = modules.get(i);
            int toggleY = startY + i * spacing - 2;

            if (mouseX >= toggleX && mouseX <= toggleX + toggleWidth &&
                mouseY >= toggleY && mouseY <= toggleY + toggleHeight) {
                m.enabled = !m.enabled; // toggle ON/OFF
            }
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        int sidebarHeight = this.height;
        int sidebarColor = 0x66000000;

        //Note to self: ALL COLORS ARE IN AARRGGBB FORMAT
        drawRect(0, 0, sidebarWidth, sidebarHeight, sidebarColor);
        drawGradientRect(sidebarWidth, 0, sidebarWidth + 2, sidebarHeight, 0x20000000, 0x00000000);

        int xButtonBottom = margin + 10; // top margin + button height
        drawRect(0, xButtonBottom + 5, sidebarWidth, xButtonBottom + 7, 0xFFFFFFFF); // white 2px line

        int startY = 50;
        int spacing = 22;

        for (int i = 0; i < modules.size(); i++) {
            Module m = modules.get(i);
            int y = startY + i * spacing;

            // Module name (left side) 
            drawString(this.fontRenderer, m.name, margin, y, 0xFFFFFFFF);

            // ON/OFF toggle (right side), the spacing is already done automatically
            int toggleWidth = 30;
            int toggleHeight = 12;
            int toggleX = sidebarWidth - toggleWidth - margin;
            int toggleY = y - 2;

            // Draw the toggle, should be able to enable/disable modules by clicking on these
            int toggleColor = m.enabled ? 0xFF00FF00 : 0xFF555555; 
            drawRect(toggleX, toggleY, toggleX + toggleWidth, toggleY + toggleHeight, toggleColor);
        }



        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
