package multithreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadFile {
	public static void main(String[] args) {
		   String fileName = "abc.txt";
		   ExecutorService service = Executors.newFixedThreadPool(5);
		   Set<String> st = ConcurrentHashMap.newKeySet();
		   
		   try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			   String line;
			   
			   while((line = br.readLine()) != null) {
				   String tempLine = line;
				   
				   service.submit(() -> {
					   String[] words = tempLine.split("[^a-zA-Z0-9]+");
					   for(String word: words) {
						   st.add(word);
					   }
				   });
 				   
			   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   service.shutdown();
		   try {
	            // wait for all tasks to finish
	            service.awaitTermination(10, TimeUnit.SECONDS);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

		   
	}
}
