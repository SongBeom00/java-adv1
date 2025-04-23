package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV4 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요 종료 (q) :");
            String input = userInput.nextLine();
            if(input.equals("q")){
//                printer.work = false;
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable{

        //동시성 때문에 volatile 나  Concurrent 사용한다.
        //volatile boolean work = true; // volatile 키워드는 main 스레드 printer 스레드가 동시에 접근할 수 있다.
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); //동시성을 지원하는 동시성 컬렉션 프레임워크이다.


        @Override
        public void run() {
            while (!Thread.interrupted()){
                if(jobQueue.isEmpty()){
                    Thread.yield(); // 추가 다른 스레드에게 작업을 양보해서 효율적으로 작업한다.
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("출력 시작 "+ job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(3000);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input){
            jobQueue.offer(input);
        }

    }


}
