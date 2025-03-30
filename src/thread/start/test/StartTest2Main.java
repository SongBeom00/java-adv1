package thread.start.test;


import static util.MyLogger.log;

public class StartTest2Main {
    // 여기에 코드 작성
    public static void main(String[] args) {
        Thread thread = new Thread(new CounterRunnable(), "counter");
        thread.start();

    }

    static class CounterRunnable implements Runnable{
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