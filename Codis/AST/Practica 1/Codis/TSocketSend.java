package practica1.Protocol;

import ast.protocols.tcp.TCPSegment;
import utils.Channel;

public class TSocketSend {

    private final Channel channel;

    public TSocketSend(Channel channel) {
        this.channel = channel;
    }

    public void sendData(byte[] data, int offset, int length) {
        byte[] valid_data = new byte[length];
        System.arraycopy(data, offset, valid_data, 0, length);
        TCPSegment seg = new TCPSegment();
        seg.setData(valid_data);
        channel.send(seg);
    }
}
