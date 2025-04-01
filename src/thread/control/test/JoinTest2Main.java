package thread.control.test;

import static util.MyLogger.log;

public class JoinTest2Main {

    public static void main(String[] args) throws InterruptedException {

        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask,"t1");
        Thread thread2 = new Thread(myTask,"t2");
        Thread thread3 = new Thread(myTask,"t3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        log("모든 스레드 실행 완료");
    }


    static class MyTask implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
            }
        }
    }


}
