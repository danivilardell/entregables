package practica2.Protocol;

import ast.protocols.tcp.TCPSegment;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica1.CircularQ.CircularQueue;
import utils.Channel;

public class MonitorChannel implements Channel {

    CircularQueue<TCPSegment> Q;
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    public MonitorChannel(int N) {
        Q = new CircularQueue<TCPSegment>(N);
    }

    @Override
    public void send(TCPSegment seg) {
        lock.lock();
        try {
            while(Q.full()){
                try {
                    full.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            empty.signal();
            Q.put(seg);
        }
        finally {
            lock.unlock();
        }
        
        
    }

    @Override
    public TCPSegment receive() {
        lock.lock();
        TCPSegment res = new TCPSegment();
        try {
            while(Q.empty()){
                try {
                    empty.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            res = Q.get();
            full.signal();
        }
        finally {
            lock.unlock();
        }
        
        return res;
    }

    @Override
    public int getMMS() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}