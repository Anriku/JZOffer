public class Test {

    static boolean isWait = true;

    public static void main(String[] args) throws InterruptedException {
//        Test test1 = new Test();
//        Test test2 = new Test();
//
//        test1.isWait = true;
//        test2.isWait = false;

        Thread thread1 = new Thread(() -> {
            try {
                Test.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();


        Thread thread2 = new Thread(() -> {
                Test.test2();

        });

        thread2.start();

        thread1.join();
        thread2.join();
    }

    public static synchronized void test() throws InterruptedException {
        if (isWait) {
            while (true) {}
        }
        System.out.println("test" + isWait);
    }

    public static synchronized void test2() {
        System.out.println("test2" + isWait);
    }
}