package test.Executor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

	private ExecutorService executor = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS,
			new ArrayBlockingQueue(5000));

	private static TestExecutor testExecutor = new TestExecutor();

	public static TestExecutor getExecutor() {
		return testExecutor;
	}

	public void doExecutor(Runnable run) {
		try {
			this.executor.execute(run);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
