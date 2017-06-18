package Tools;


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadManager implements IConstants {
	
	private static ThreadManager instance = null;
	private ExecutorService Executor;

	protected ThreadManager() {
		Executor = Executors.newFixedThreadPool(MAX_THREAD_POOL_SIZE);
	}
	
	public static ThreadManager getInstance(){
		if(instance == null){
			instance = new ThreadManager();
		}
		return instance;
	}
	
	public ExecutorService getExecutor(){
		return Executor;
	}

}