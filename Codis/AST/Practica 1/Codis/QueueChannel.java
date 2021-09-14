package practica1.Protocol;

import ast.protocols.tcp.TCPSegment;
import practica1.CircularQ.CircularQueue;
import utils.Channel;

public class QueueChannel implements Channel {

    CircularQueue<TCPSegment> Q;

    public QueueChannel(int N) {
        Q = new CircularQueue<TCPSegment>(N);
    }

    @Override
    public void send(TCPSegment s) throws IllegalStateException {
        //Si la cua esta plena tirara la excepcio
        Q.put(s);
    }

    @Override
    public TCPSegment receive() throws IllegalStateException {
        //Si la cua esta buida tirara la excepcio
        return Q.get();
    }

    @Override
    public int getMMS() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
