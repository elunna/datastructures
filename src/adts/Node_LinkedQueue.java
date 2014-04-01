package adts;

/**
 * File:        
 * Description: 
 * @author lunatunez
 */

public class Node_LinkedQueue<T> {
    private T data;
    private Node_LinkedQueue next;

    public Node_LinkedQueue(T data, Node_LinkedQueue next) {
        this.data = data;
        this.next = next;
    }

    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node_LinkedQueue getNext() {
        return next;
    }

    public void setNext(Node_LinkedQueue next) {
        this.next = next;
    }
    
    
}
