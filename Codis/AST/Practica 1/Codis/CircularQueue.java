package practica1.CircularQ;

import java.util.Iterator;
import utils.Queue;

public class CircularQueue<E> implements Queue<E> {
    
    private final E[] queue;
    private final int N;
    private int elements;
    private int first;
    private int last;

    public CircularQueue(int N) {
    	//Tot i que no es necessari assignem elements, first i last a 0 per claretat
        this.N = N;
        this.elements = 0;
        this.first = 0;
        this.last = 0;
        queue = (E[]) (new Object[N]);
    }

    @Override
    public int size() {return elements;}

    @Override
    public int free() {return N - elements;}

    @Override
    public boolean hasFree(int n) {return N != elements;}

    @Override
    public boolean empty() {return elements == 0;} //Si esta buida conte 0 elements

    @Override
    public boolean full() {return N == elements;}

    @Override
    public E peekFirst() {
    	//Cal mirar primer que no estigui buida, al igual que al metode get() i peekLast()
        if(empty()) throw new IllegalStateException("cua buida");
        return queue[first];
    }

    @Override
    public E peekLast() {
        if(empty()) throw new IllegalStateException("cua buida");
        return queue[last];
    }

    @Override
    public E get() {
        if(empty()) throw new IllegalStateException("cua buida");
        E e = queue[first];
        first = (N + first + 1)%N;
        elements--;
        return e;
    }

    @Override
    public void put(E e) {
    	//Cal mirar que no estigui plena
        if(full()) throw new IllegalStateException("cua plena");
        queue[last] = e;
        last = (N + last + 1)%N;
        elements++;
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
        public void remove() {throw new UnsupportedOperationException("Not supported yet.");}

    }
}
