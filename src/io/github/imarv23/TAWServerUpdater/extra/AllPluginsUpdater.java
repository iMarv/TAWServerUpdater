package io.github.imarv23.TAWServerUpdater.extra;

import io.github.imarv23.TAWServerUpdater.files.PluginManager;

import java.io.File;

public class AllPluginsUpdater {

	private String source;
	private String path;
	
	public AllPluginsUpdater(String source, String path)
	{
		this.source = source;
		this.path = path;
	}
	
	public void update()
	{
		File[] pluginList = new File(this.source).listFiles();
		for(File plugin : pluginList)
		{
			PluginManager pm = new PluginManager(plugin.getAbsolutePath());
			System.out.println(plugin.getName());
			pm.checkForUpdates(this.path);
		}
	}
}
