package vazkii.minetunes.playlist;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

import vazkii.minetunes.gui.GuiDevTools;
import vazkii.minetunes.playlist.provider.IProviderStateCallback;
import vazkii.minetunes.playlist.provider.PlaylistProvider;
import vazkii.minetunes.playlist.provider.ProviderDirectory;
import vazkii.minetunes.playlist.provider.ProviderM3U;

public class Playlist {

	public SortedSet<MP3Metadata> metadataSet = new TreeSet();
	
	public static Playlist build(File file, IProviderStateCallback callback) {
		PlaylistProvider provider = file.isDirectory() ? ProviderDirectory.instance : file.getName().endsWith(".m3u") ? ProviderM3U.instance : null;
		return provider == null ? null : provider.provide(file, callback);
	}
	
}
