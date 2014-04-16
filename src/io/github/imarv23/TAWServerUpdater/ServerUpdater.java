package io.github.imarv23.TAWServerUpdater;

import io.github.imarv23.TAWServerUpdater.files.FileManager;

public class ServerUpdater {

	public static void main(String[] args) {
		try{
			FileManager fm = new FileManager(args[0]);
			fm.checkForUpdates(args[1]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("There is at least one attribute missing.\n Make sure that you run the jar like this:");
			System.out.println("TawServerUpdater.jar <complete path to source file> <complete path to destination folder>");
			System.out.println("Make sure that the folders in the destination folder are named like that:\n server_0, server_1, server_2 (...)");
		}
	}

}
