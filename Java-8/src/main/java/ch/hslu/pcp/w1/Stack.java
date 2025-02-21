package ch.hslu.pcp.w1;

public class Stack {
    private Element top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("print - Stack is empty");
            return;
        }

        System.out.print("print - Stack contains: ");
        Element current = top;
        while (current != null) {
            System.out.print(current.getValue() + ", ");
            current = current.getNext();
        }
        System.out.println("top Element = " + top().getValue());
    }

    public Element top() {
        if (isEmpty()) {
            return null;
        }
        return top;
    }

    public void push(Element e) {
        e.setNext(top);
        top = e;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        top = top.getNext();
        size--;
    }
}