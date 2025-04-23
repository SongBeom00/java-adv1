package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +  " - " + i);
                //1. empty -> 한 스레드가 일정하게 0 ~ 9 까지 계속 출력하다가 context switch 를 한다.
                //sleep(1); // 2. sleep
                 Thread.yield(); // 3. yield

            }
        }
    }

}
