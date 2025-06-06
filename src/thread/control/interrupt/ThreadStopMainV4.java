package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask,"work");
        thread.start();

        sleep(100); // 시간을 줄임
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted()); // 인터럽트 상태 true

    }

    static class MyTask implements Runnable{


        @Override
        public void run() {

            while(!Thread.interrupted()) { // 인터럽트 상태 변경 O -> 현재 스레드의 인터럽트 상태를 false로 바꾼다.
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // 인터럽트 상태 false

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 3 = "+ Thread.currentThread().isInterrupted()); // 인터럽트 상태 false
            }
            log("작업 종료");
        }
    }
}
