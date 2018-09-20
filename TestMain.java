package test.Executor;

public class TestMain {

	public static void main(String[] args) {
		test("1");
		test("2");
	}

	private static void test(String a) {
		TestExecutor.getExecutor().doExecutor(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + "===========" + i);
					System.out.println(a);
				}
			}
		});
	}
}
