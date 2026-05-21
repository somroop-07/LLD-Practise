package file_filtering_system_LLD.FilterStrategy;

import java.util.List;

import file_filtering_system_LLD.entitites.FileSystemComponent;

public class ANDStrategy implements FilterStrategy {
	
	List<FilterStrategy> strategies;

	public ANDStrategy(List<FilterStrategy> strategies) {
		super();
		this.strategies = strategies;
	}

	@Override
	public boolean filter(FileSystemComponent component) {
		for(FilterStrategy strategy : strategies) {
			if(!strategy.filter(component)) {
				return false;
			}
		}
		return true;
	}
	
	

}
