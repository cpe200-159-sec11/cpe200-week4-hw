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

        PNode temp = head, temp2;

        while (temp != null) {
            if (temp.data.equals(data)) {
                if(temp == head)
                {
                    popHead();
                    return true;
                }
                else if(temp == tail)
                {
                    popTail();
                    return true;
                }
                else
                {
                    temp2 = temp.prev;
                    temp2.next = temp.next;
                    temp.next.prev = temp2;
                    size --;
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    public Object elementAt(int index) {
        PNode temp=head;
        if(index >= 0 && index<size)
        {
            for(int i=0;i<index;i++) {
                temp = temp.next;
            }    
            return temp.data;
        }

        return null;
    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        PNode temp = head;
        while(temp != null)
        {
            if(temp.data.equals(data))
            {
                return true;
            }
            temp = temp.next;
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
