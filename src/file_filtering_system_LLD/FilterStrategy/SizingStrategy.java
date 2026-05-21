package file_filtering_system_LLD.FilterStrategy;

import file_filtering_system_LLD.entitites.FileSystemComponent;

public class SizingStrategy implements FilterStrategy{
	
	long maxSize;
	
	public SizingStrategy(long minSize) {
		super();
		this.maxSize = minSize;
	}
    

	public void setMinSize(long minSize) {
		this.maxSize = minSize;
	}


	@Override
	public boolean filter(FileSystemComponent component) {
		if(component.getSize() <= maxSize) {
			return true;
		}
		return false;
	}

}
