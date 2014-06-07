package io.github.imarv23.TAWServerUpdater;

import io.github.imarv23.TAWServerUpdater.extra.AllPluginsUpdater;
import io.github.imarv23.TAWServerUpdater.files.FileManager;
import io.github.imarv23.TAWServerUpdater.files.PluginManager;

public class ServerUpdater {

	public static void main(String[] args) {
		try{
			if("server".equals(args[2]))
			{
				FileManager fm = new FileManager(args[0]);
				System.out.println("Updating Server jars");
				fm.checkForUpdates(args[1]);
			}else if("plugin".equals(args[2]))
			{
				PluginManager pm = new PluginManager(args[0]);
				System.out.println("Updating plugin");
				pm.checkForUpdates(args[1]);
			}else if("allplugins".equals(args[2]))
			{
				AllPluginsUpdater apu = new AllPluginsUpdater(args[0], args[1]);
				System.out.println("Updating all plugins");
				apu.update();
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("One or more parameters are wrong, check the readme on github to make sure that you are using this tool correctly.");
		}
	}

}
