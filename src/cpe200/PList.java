package cpe200;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(Object i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(Object i) {
        tail = new PNode(i,null, tail);
        if (head==null)
            head = tail;
        else
            tail.prev.next = tail;
        size++;
    }

    public Object popHead() {
        Object data=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return data;
    }

    public Object popTail() {
        Object data=tail.data;
        PNode tmp = tail;

        if (tail==head)
            tail = head = null;
        else {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }

        size--;

        return data;
    }

    public boolean remove(Object data) {
        PNode tmp = head;
        PNode temp1 = head;
        PNode temp2 = head;
        while (tmp != null) {
            if (tmp.data.equals(data)) {
                System.out.println(data);
                if (tmp == head) {
                    popHead();
                }
                else if (tmp == tail) {
                    popTail();
                }
                else {
                    temp1 = tmp.prev;
                    temp2 = tmp.next;
                    temp1.next = temp2;
                    temp2.prev = temp1;
                }
                size--;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    public Object elementAt(int index) {
        // implement your code here!!!
        // what if index is not in between 0 to (size-1)
        PNode tmp = head;
        int count = 0;
        if(index>size-1 || index <0)
        {
            return null;
        }
        else{
            while (tmp !=null)
            {
                if(count == index)
                {
                    break;
                }
                count++;
                tmp = tmp.next;
            }
        }

        return tmp.data;
    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        // implement your code here!!!
        PNode tmp =head;
        while (tmp!=null)
        {
            if (tmp.data.equals(data)) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
