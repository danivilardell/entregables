package practica1.LinkedQ;

import java.util.Iterator;
import utils.Queue;

public class LinkedQueue<E> implements Queue<E> {

    private final int N;
    private Node<E> first;
    private Node<E> last;
    private int size;
    
    public LinkedQueue (int N) {
        //Inicialment posem first i last a null
        this.N = N;
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int size() {return size;}

    @Override
    public int free() {return N - size;}

    @Override
    public boolean hasFree(int n) {return size != N;}

    @Override
    public boolean empty() {return size == 0;}

    @Override
    public boolean full() {return size == N;}

    @Override
    public E peekFirst() {
        //Mirem que no estigui buida
        if(empty()) throw new IllegalStateException("cua buida");
        return first.getValue();
    }

    @Override
    public E peekLast() {
        //Mirem que no estigui buida
        if(empty()) throw new IllegalStateException("cua buida");
        return last.getValue();
    }

    @Override
    public E get() {
        //Mirem que no estigui buida
        if(empty()) throw new IllegalStateException("cua buida");
        E e = first.getValue();
        if(size != 1) {first = first.getNext();}
        size--;
        return e;
    }

    @Override
    public void put(E value) {
        //Mirem que no estigui plena
        if(full()) throw new IllegalStateException("cua plena");
        Node n = new Node(value, null);
        //Si esta buida fem assignacions pertinents
        if(empty()) {
            first = n; last = n; size++;
            return;
        }
        size++;
        last.setNext(n);
        last = n;
    }

    @Override
    public Iterator<E> iterator() {return new MyIterator();}

    class MyIterator implements Iterator {

        @Override
        public boolean hasNext() {return !empty();}

        @Override
        public E next() {
            E e = get();
            return e;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
