package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main {

    public static void main(String[] args) throws InterruptedException {

        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask,"t1");
        Thread thread2 = new Thread(myTask,"t2");
        Thread thread3 = new Thread(myTask,"t3");

        thread1.start(); // 3초
        thread1.join(); // 대기

        thread2.start(); // 3초
        thread2.join(); // 대기

        thread3.start(); // 3초
        thread3.join(); // 대기

        log("총 실행 시간 : " + myTask.result + "초");

    }



    static class MyTask implements Runnable{

        int result;

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
                result++;
            }
        }
    }



}
