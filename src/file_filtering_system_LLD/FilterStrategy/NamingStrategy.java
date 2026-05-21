package file_filtering_system_LLD.FilterStrategy;

import file_filtering_system_LLD.entitites.FileSystemComponent;

public class NamingStrategy implements FilterStrategy{

	 String keyword;

	 public NamingStrategy(String nameMatch) {
		super();
		this.keyword = nameMatch;
	 }

	 public void setNameMatch(String nameMatch) {
		 this.keyword = nameMatch;
	 }

	 @Override
	 public boolean filter(FileSystemComponent component) {
		if(component.getName().contains(keyword)) {
			return true;
		}
		return false;
	 }
	 
	 
	 
}
