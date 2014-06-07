package io.github.imarv23.TAWServerUpdater.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.*;

public class FileManager {
	
	private File sourceFile;
	private long lastModified;
	private int successfulUpdates;
	private int filesAlreadyUpToDate;
	private int failedUpdates;
	/**
	 * Constructor
	 * Saves the original file & gets the date when it was modified the last time
	 * @param source
	 */
	public FileManager(String source)
	{
		this.successfulUpdates = 0;
		this.failedUpdates = 0;
		this.filesAlreadyUpToDate = 0;
		
		this.sourceFile = new File(source);
		this.lastModified = this.sourceFile.lastModified();
	}
	
	/**
	 * Compares the "original" file with the ones in the folders given by the path and replaces old files.
	 * @param path
	 */
	public void checkForUpdates(String path)
	{
		File[] directoryList = new File(path).listFiles();
		ArrayList<File> filesToUpdate = new ArrayList<File>();
		
		for(File directory : directoryList)
		{
			filesToUpdate.add(new File(directory.getPath() + "\\" +  this.sourceFile.getName()));
		}
		
		for(File fileToCompare : filesToUpdate)
		{
			if(fileToCompare.lastModified() != this.lastModified)
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
	}
	
}
