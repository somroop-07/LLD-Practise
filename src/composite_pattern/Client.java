package composite_pattern;

import java.util.ArrayList;
import java.util.List;

interface FileDirectory {
	void ls();
}

class File implements FileDirectory {

	String fileName;
	
	public File(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void ls() {
		System.out.println("File Name: " + fileName);
		
	}
	
}

class Folder implements FileDirectory {

	String folderName;
	List<FileDirectory> fileList; 
	
	public Folder(String folderName) {
		this.folderName = folderName;
		fileList = new ArrayList<>();
	}
	
	public void addFileDirectory(FileDirectory fileDirectory) {
		fileList.add(fileDirectory);
	}
	
	@Override
	public void ls() {
		System.out.println("Folder Name: " + folderName);
		
		for(FileDirectory fd: fileList) {
			fd.ls();
		}
	}
	
}

public class Client {
    
	public static void main(String[] args) {
		Folder rootFolder = new Folder("Movies");
		File file1 = new File("Sherlock");
		rootFolder.addFileDirectory(file1);
		Folder marvelMovies = new Folder("Marvel");
		File file2 = new File("End Game");
		marvelMovies.addFileDirectory(file2);
		rootFolder.addFileDirectory(marvelMovies);
		rootFolder.ls();
		
	}
}
