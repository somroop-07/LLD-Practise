package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
   public static void main(String[] args) {
	ExecutorService executor =  Executors.newFixedThreadPool(5);
	executor.submit(() -> {
		System.out.println("Threads running");
	});
	executor.submit(() -> {
		System.out.println("Threads running");
	});
	executor.shutdown();
}
}
