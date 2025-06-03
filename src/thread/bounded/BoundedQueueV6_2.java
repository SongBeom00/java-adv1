package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue{


    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max); // 큐 크기를 지정해줘야 한다.
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result); // 버퍼가 가득 차있는 경우 데이터를 추가하지 않고 즉시 false 반환한다.
    }

    @Override
    public String take() {
        return queue.poll(); // 버퍼에 데이터가 없는 경우 대기하지 않고 null 반환
    }


    @Override
    public String toString() {
        return queue.toString();
    }
}
