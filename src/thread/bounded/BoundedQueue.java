package thread.bounded;

/**
 * 버퍼 역할을 하는 큐의 인터페이스이다.
 */
public interface BoundedQueue {

    void put(String data); // 생산자 스레드가 호출하고 데이터를 생산한다.

    String take(); // 소비자 스레드가 호출하고 데이터를 소비한다.

}
