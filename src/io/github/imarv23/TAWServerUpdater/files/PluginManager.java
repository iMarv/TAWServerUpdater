package io.github.imarv23.TAWServerUpdater.files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class PluginManager {

	private File sourceFile;
	private long lastModified;
	private int successfulUpdates;
	private int filesAlreadyUpToDate;
	private int failedUpdates;
	private int noFileToUpdate;
	
	public PluginManager(String source) {
		this.successfulUpdates = 0;
		this.failedUpdates = 0;
		this.filesAlreadyUpToDate = 0;
		this.noFileToUpdate = 0;
		
		this.sourceFile = new File(source);
		this.lastModified = this.sourceFile.lastModified();
	}

	public void checkForUpdates(String path)
	{
		File[] directoryList = new File(path).listFiles();
		ArrayList<File> filesToUpdate = new ArrayList<File>();
		
		for(File directory : directoryList)
		{
			filesToUpdate.add(new File(directory.getPath() + "\\plugins\\" +  this.sourceFile.getName()));
		}
		
		for(File fileToCompare : filesToUpdate)
		{
			if(fileToCompare.lastModified() != this.lastModified && fileToCompare.lastModified() > 0)
			{
				try{
					Files.copy(this.sourceFile.toPath(), fileToCompare.toPath(), REPLACE_EXISTING);
					System.out.println(this.sourceFile.getName());
					this.successfulUpdates++;
				}
				catch(IOException e)
				{
					this.successfulUpdates--;
					this.failedUpdates++;
					System.out.println(e.getMessage());
				}
			}else if(fileToCompare.lastModified() == this.lastModified)
			{
				this.filesAlreadyUpToDate++;
			
			}else if(fileToCompare.lastModified() <= 0){
				this.noFileToUpdate++;
			}else{
				System.out.println("Unknown Error");
			}
		}
		
		this.printStatistics();
	}
	
	private void printStatistics()
	{
		System.out.println(this.filesAlreadyUpToDate + " files already up to date,");
		System.out.println(this.successfulUpdates + " files have been updated,");
		System.out.println(this.failedUpdates + " file updates failed.");
		System.out.println(this.noFileToUpdate + " directories without the plugin. \n");
	}
}
