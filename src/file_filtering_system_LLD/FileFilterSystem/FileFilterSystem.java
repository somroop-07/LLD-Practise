package file_filtering_system_LLD.FileFilterSystem;

import java.util.ArrayList;
import java.util.List;

import file_filtering_system_LLD.FilterStrategy.FilterStrategy;
import file_filtering_system_LLD.entitites.File;
import file_filtering_system_LLD.entitites.FileSystemComponent;
import file_filtering_system_LLD.entitites.Folder;

public class FileFilterSystem {

	public List<FileSystemComponent> filter(FileSystemComponent directory,
			FilterStrategy strategy) {
		
		List<FileSystemComponent> filteredList = new ArrayList<>();
		dfs(directory, filteredList, strategy);
		return filteredList;
	}
	
	public void dfs(FileSystemComponent current, List<FileSystemComponent> filteredList,
			FilterStrategy strategy) {
		
		if(current instanceof File) {
			if(strategy.filter(current)) {
				filteredList.add(current);
			}
			return;
		}
		if(current instanceof Folder) {
		
		Folder temp = (Folder)current;
		for(FileSystemComponent children : temp.getChildren()) {
			dfs(children, filteredList, strategy);
		}
		}
	}
}
