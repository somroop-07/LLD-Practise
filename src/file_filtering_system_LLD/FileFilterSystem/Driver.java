package file_filtering_system_LLD.FileFilterSystem;

import file_filtering_system_LLD.entitites.Folder;

import java.util.List;

import file_filtering_system_LLD.FilterStrategy.ANDStrategy;
import file_filtering_system_LLD.FilterStrategy.NamingStrategy;
import file_filtering_system_LLD.FilterStrategy.SizingStrategy;
import file_filtering_system_LLD.entitites.File;
import file_filtering_system_LLD.entitites.FileSystemComponent;

public class Driver {
      
	public static void main(String[] args) {
		Folder root = new Folder("root");
		File f1 = new File("AkashFile2", "acbdfsd", 1000);
		File f2 = new File("AkashFile", "gsfg", 500);
		File f3 = new File("SomroopFile", "acbngbdgdfsd", 700);
		
		root.add(f1);
		root.add(f2);
		root.add(f3);
		
		NamingStrategy strategy1 = new NamingStrategy("Akash");
		SizingStrategy strategy2 = new SizingStrategy(5000);
		ANDStrategy strategy3 = new ANDStrategy(List.of(strategy1,strategy2));
		
		FileFilterSystem fileFilterSystem = new FileFilterSystem();
		List<FileSystemComponent> filteredList = fileFilterSystem.filter(root, strategy1);
		
		for(FileSystemComponent fileSystemComponent : filteredList) {
			System.out.println(fileSystemComponent.getName());
		}
	}
}
