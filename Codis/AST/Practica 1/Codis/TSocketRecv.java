package practica1.Protocol;

import ast.protocols.tcp.TCPSegment;
import utils.Channel;

public class TSocketRecv {

    private final Channel channel;

    public TSocketRecv(Channel channel) {
        this.channel = channel;
    }

    //Retorna la quantitat de dades que s'ha pogut extreure, min(les que hi ha, les demanades)
    public int receiveData(byte[] data, int offset, int length) {
        TCPSegment receive = channel.receive();
        System.arraycopy(receive.getData(), receive.getDataOffset(), data, offset, Math.min(receive.getDataLength(), length));
        return Math.min(receive.getDataLength(), length);
    }
}
