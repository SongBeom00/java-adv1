package thread.start.test;


import static util.MyLogger.log;

public class StartTest1Main {
    // 여기에 코드 작성
    public static void main(String[] args) {
        CounterThread thread = new CounterThread();
        thread.start();
    }

    static class CounterThread extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 1; i < 6; i++) {
                    log("value : " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}