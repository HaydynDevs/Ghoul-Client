package net.minecraft.src;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.TextureLocation;
import net.minecraft.client.Minecraft;

public class GuiMainButton extends GuiButton {

    private static final TextureLocation tex_gui = new TextureLocation("/gui/GhoulClient/mainGui.png");

    public GuiMainButton(int id, int x, int y, String text) {
        this(id, x, y, 200, 20, text);
    }

    public GuiMainButton(int id, int x, int y, int width, int height, String text) {
        super(id, x, y, width, height, text); // initialize parent fields properly
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {

        if (!this.drawButton) return;

        FontRenderer font = mc.fontRenderer;
        tex_gui.bindTexture();
        EaglerAdapter.glColor4f(1f, 1f, 1f, 1f);

        this.field_82253_i = mouseX >= this.xPosition && mouseY >= this.yPosition
                && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;

        int hover = this.getHoverState(this.field_82253_i);

        // draw left and right halves of the button
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + hover * 20, this.width / 2, this.height);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, this.width / 2, 46 + hover * 20, this.width / 2, this.height);

        this.mouseDragged(mc, mouseX, mouseY);

        int color = 14737632; // default
        if (!this.enabled) color = -6250336;
        else if (this.field_82253_i) color = 16777120;

        this.drawCenteredString(font, this.displayString, this.xPosition + this.width / 2,
                this.yPosition + (this.height - 8) / 2, color);
    }
}
