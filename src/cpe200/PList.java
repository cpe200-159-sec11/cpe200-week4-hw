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

        PNode tmp = head, tmp2;

        while (tmp != null) {
            if (tmp.data.equals(data)) {
                // implement your code here!!!

                // case 1: head of the list
                if(head.data==data){
                    popHead();
                    return true;
                }

                // case 2: tail of the list
                if(tail.data==data){
                    popTail();
                    return true;
                }

                // case 3: somewhere in the middle
                if(tmp.data.equals(data)){
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                    return true;
                }
           }
            tmp = tmp.next;
        }
        return false;
    }

    public Object elementAt(int index) {
        // implement your code here!!!
        PNode tmp = head;
            if(index>=0&&index<getSize()-1) {

                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                return tmp.data;
            }
            // what if index is not in between 0 to (size-1)
        else return null;


    }

 // rename the search method to "found(Object data)"
   public boolean found(Object data) {
       // implement your code here!!!
       PNode tmp=head;
               while(tmp!=null){
                if(tmp.data.equals(data))
                    return true;
                tmp=tmp.next;
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
