package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task,"work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable{

//        boolean runFlag = true; //각자 스레드의 캐시 메모리
        volatile boolean runFlag = true; //캐시 메모리를 쓰지 않고 값을 읽거나 쓸 떄 항상 메인 메모리에 직접 접근한다.

        @Override
        public void run() {

            log("task 시작");
            //work 스레드가 while 문에서 탈출 못하고 있다.
            while (runFlag){
                //runFlag가 false로 변하면 탈출
            }
            log("task 종료");

        }
    }


}
