package practica2.P1Sync.Monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorSync {
    
    ReentrantLock lock = new ReentrantLock();
    private final int N;
    private static int turn = 0;

    public MonitorSync(int N) {
        this.N = N;
    }

    public void waitForTurn(int id) {
        lock.lock();
        while(this.turn != id){lock.unlock(); lock.lock();}
        lock.unlock();
    }

    public void transferTurn() {
        turn = (turn + 1)%N;
    }
}
