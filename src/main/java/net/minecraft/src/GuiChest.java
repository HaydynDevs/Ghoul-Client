package net.minecraft.src;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.TextureLocation;
import net.lax1dude.eaglercraft.adapter.Tessellator;


public class GuiChest extends GuiContainer {
	private IInventory upperChestInventory;
	private IInventory lowerChestInventory;

	/**
	 * window height is calculated with this values, the more rows, the heigher
	 */
	private int inventoryRows = 0;

	public GuiChest(IInventory par1IInventory, IInventory par2IInventory) {
		super(new ContainerChest(par1IInventory, par2IInventory));
		this.upperChestInventory = par1IInventory;
		this.lowerChestInventory = par2IInventory;
		this.allowUserInput = false;
		short var3 = 222;
		int var4 = var3 - 108;
		this.inventoryRows = par2IInventory.getSizeInventory() / 9;
		this.ySize = var4 + this.inventoryRows * 18;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the
	 * items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(this.lowerChestInventory.isInvNameLocalized() ? this.lowerChestInventory.getInvName() : StatCollector.translateToLocal(this.lowerChestInventory.getInvName()), 8, 6, 4210752);
		this.fontRenderer.drawString(this.upperChestInventory.isInvNameLocalized() ? this.upperChestInventory.getInvName() : StatCollector.translateToLocal(this.upperChestInventory.getInvName()), 8, this.ySize - 96 + 2, 4210752);
	}
	
	private static final TextureLocation tex = new TextureLocation("/gui/container.png");
	private static final TextureLocation LogoLong = new TextureLocation("/gui/GhoulClient/logoLong.png");


	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		EaglerAdapter.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		tex.bindTexture();
		int var4 = (this.width - this.xSize) / 2;
		int var5 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.drawTexturedModalRect(var4, var5 + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);

		LogoLong.bindTexture(); // replace with your texture variable name

		float texWidth = 688f;
		float texHeight = 188f;
		int imgWidth = 160;
		int imgHeight = 40;
		int imageCoordX = (this.width / 2) - (imgWidth / 2);
		int imageCoordY = 5;

		// Draw scaled texture
		EaglerAdapter.glPushMatrix();
		EaglerAdapter.glTranslatef(imageCoordX, imageCoordY, 0.0f);
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		tess.addVertexWithUV(0, imgHeight, 0, 0.0, 1.0);        
		tess.addVertexWithUV(imgWidth, imgHeight, 0, 1.0, 1.0); 
		tess.addVertexWithUV(imgWidth, 0, 0, 1.0, 0.0);         
		tess.addVertexWithUV(0, 0, 0, 0.0, 0.0);              
		tess.draw();

		EaglerAdapter.glPopMatrix();
	}
}
