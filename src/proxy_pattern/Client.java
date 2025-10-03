package proxy_pattern;

interface ImageLoaderInterface {
	void loadImage();
}

class ImageLoader implements ImageLoaderInterface {

	String fileName;
	public ImageLoader(String filename) {
		this.fileName = filename;
		loadFromDisk();
	}
	
	public void loadFromDisk() {
		System.out.println("Loading image from Harddisk " + fileName);
	}
	@Override
	public void loadImage() {
		System.out.println("Displaying image... ");
	}
}

class ImageLoaderProxy implements ImageLoaderInterface {

	String filename;
	ImageLoader loader;
	
	
	
	public ImageLoaderProxy(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public void loadImage() {
		if(loader == null) {
		loader = new ImageLoader(filename);
		}
		loader.loadImage();
	}
	
}
public class Client {
  public static void main(String[] args) {
	ImageLoaderProxy loaderProxy1 = new ImageLoaderProxy("image1.png");
	loaderProxy1.loadImage();
	ImageLoaderProxy loaderProxy2 = new ImageLoaderProxy("image2.png");
}
}
