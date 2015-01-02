package vazkii.minetunes;

import java.io.File;
import java.lang.management.ManagementFactory;

import vazkii.minetunes.config.CacheHelper;
import vazkii.minetunes.config.MTConfig;
import vazkii.minetunes.key.KeyBindings;
import vazkii.minetunes.lib.LibMisc;
import vazkii.minetunes.player.ThreadMusicPlayer;
import vazkii.minetunes.playlist.ThreadPlaylistCreator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION)
public class MineTunes {

	public static boolean DEBUG_MODE = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;

	public volatile static ThreadMusicPlayer musicPlayerThread;
	public volatile static ThreadPlaylistCreator playlistCreatorThread;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		KeyBindings.init();
		MTConfig.findCompoundAndLoad();
	}
	
	public static void startMusicPlayerThread() {
		musicPlayerThread = new ThreadMusicPlayer();
	}
	
	public static void startPlaylistCreatorThread(File file, String name) {
		playlistCreatorThread = new ThreadPlaylistCreator(file, name);
	}
	
}
