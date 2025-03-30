package thread.start.test;


import static util.MyLogger.log;

public class StartTest3Main {
    // 여기에 코드 작성
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {

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
        };
        Thread thread = new Thread(runnable, "counter");
        thread.start();

    }


}