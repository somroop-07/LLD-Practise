package file_filtering_system_LLD.entitites;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{

	String folderName;
	List<FileSystemComponent> fileComponentList;
	long size;
	
	
	public Folder(String folderName) {
		super();
		this.folderName = folderName;
		this.fileComponentList = new ArrayList<>();
		this.size = 0;
	}
	@Override
	public void showContents() {
		for(FileSystemComponent fileSystemComponent : fileComponentList) {
			fileSystemComponent.showContents();
		}
		
	}
	@Override
	public String getName() {
		return folderName;
	}
	@Override
	public long getSize() {
		for(FileSystemComponent fileSystemComponent : fileComponentList) {
			this.size += fileSystemComponent.getSize();
		}
		return size;
	}
	public void add(FileSystemComponent fileSystemComponent) {
		fileComponentList.add(fileSystemComponent);
	}
	public List<FileSystemComponent> getChildren() {
		return fileComponentList;
	}
	
}
