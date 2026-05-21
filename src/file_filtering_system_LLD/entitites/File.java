package file_filtering_system_LLD.entitites;

public class File implements FileSystemComponent{

	String fileName;
	String content;
	long size;
	
	public File(String fileName, String content, long size) {
		this.fileName = fileName;
		this.content = content;
		this.size = size;
	}
	
	@Override
	public void showContents() {
		System.out.println("filename : " + fileName + " + content : " + content );
		
	}

	public String getName() {
		return fileName;
	}

	public String getContent() {
		return content;
	}

	public long getSize() {
		return size;
	}
	

}
