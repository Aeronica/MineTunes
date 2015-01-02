package vazkii.minetunes.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import vazkii.minetunes.MineTunes;
import vazkii.minetunes.gui.playlist.GuiPlaylistManager;

public class GuiMineTunesMenu extends GuiMineTunes {

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(new GuiButton(0, width / 2 - 100, height / 2, 200, 20, StatCollector.translateToLocal("minetunes.gui.playlists")));
		buttonList.add(new GuiButton(1, width / 2 - 100, height / 2 + 25, 95, 20, StatCollector.translateToLocal("minetunes.gui.options")));
		buttonList.add(new GuiButton(2, width / 2 + 6, height / 2 + 25, 95, 20, StatCollector.translateToLocal("minetunes.gui.exit")));
		
		if(MineTunes.DEBUG_MODE)
			buttonList.add(new GuiButton(3, width / 2 - 100, height / 2 + 50, 200, 20, StatCollector.translateToLocal("minetunes.gui.devTools")));
	}
	
	@Override
	public void drawScreen(int mx, int my, float partialTicks) {
		String title = StatCollector.translateToLocal("minetunes.gui.title");
		int titleWidth = mc.fontRenderer.getStringWidth(title);
		
		drawBox(width / 2 - 120, height / 2 - 40, 240, MineTunes.DEBUG_MODE ? 125 : 100);
		
		GL11.glScalef(2F, 2F, 2F);
		mc.fontRenderer.drawString(title, (width - titleWidth * 2) / 4, height / 4 - 15, 0xFFFFFF);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		
		super.drawScreen(mx, my, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
		case 0: 
			mc.displayGuiScreen(new GuiPlaylistManager());
			break;
		case 1:
			break;
		case 2:
			mc.displayGuiScreen(null);
			break;
		case 3:
			mc.displayGuiScreen(new GuiDevTools());
			break;
		}
	}
	
}
