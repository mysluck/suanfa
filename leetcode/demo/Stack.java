package demo;

public class Stack<T> {

    private Node<T> head;
    private Node<T> tail;

    public Stack() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 压站
     *
     * @param t
     */
    public void push(T t) {
        Node cur = new Node(t);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            head.setPre(cur);
            cur.setNext(head);
            head = cur;

        }
    }

    public T pop() {
        if (head != null) {
            T value = head.getValue();
            head = head.getNext();
            return value;
        } else {
            tail = null;
        }
        return null;
    }


    public T poll() {
        T ans = null;
        if (tail == null) {
            return ans;
        }
        ans = tail.getValue();
        tail = tail.getPre();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        return ans;
    }


}
