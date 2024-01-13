public class Linked_list {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1 creating new node
        Node newNode = new Node(data);

        size++;// this incriment size of linkedlist

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 assigning next to head
        newNode.next = head;

        // step3 old head = newnode head
        head = newNode;
    }

    public void addLast(int data) {
        // all steps same as addFirst
        Node newNode = new Node(data);

        size++;// this incriment size of linkedlist

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head; // points to 0th index

        while (temp != null) {
            System.out.print(temp.data + "->  ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void addmiddle(int indx, int data) {
        // this is to criate node when LL have 0 elements
        if (indx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);

        size++;// this incriment size of linkedlist

        Node temp = head;
        int i = 0;

        // this loop finds previous node
        while (i < indx - 1) {
            temp = temp.next;
            i++;
        }

        // this step make newnode point ot temp node nxt and temp nxt point to new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst() {
        // this tackel 0 and 1 LL cases
        if (size == 0) {
            System.out.println("linkedlist is empty");
        } else if (size == 1) {
            head = tail = null;
            size--; // size decrease
        }

        head = head.next;
        size--; // size decrease
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
        }
        if (size == 1) {
            head = tail = null;
            size--;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;

    }

    public int searchIterative(int key) {

        int indx = 0;
        Node ptr = head;
        if (size == 0) {
            System.out.println("LL is empty");
            return -1;
        }
        if (size == 1) {
            if (ptr.data == key) {
                System.out.println("0");
                return indx;
            }
        }

        while (ptr != null) {
            if (ptr.data == key) {
                System.err.println(indx);
                return indx;
            }
            indx++;
            ptr = ptr.next;
        }
        System.out.println("-1");
        return -1;
    }

    // this is recursion solution of the searching key
    public int helper(Node head, int key) {
        // checking key exist or not
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        // incrimenting +1 on every step
        return idx + 1;
    }

    public int recsearch(int key) {
        return helper(head, key);
    }

    // code for LL revarsal
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // remove nth node from last
    public void delete_Nth_From_End(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        // sz-n
        int i = 1;
        int itofind = sz - n;
        Node prev = head;
        while (i < itofind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // check if LL is palindrome or not

    // finding mid
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // this is mid
    }

    public boolean checkpalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1- find mid
        Node miNode = findMid(head);

        // step2- reverse 2nd half
        Node prev = null;
        Node curr = miNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // step3- check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {

        Linked_list ll = new Linked_list();
        ll.print();

        // addFirst
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();

        // addLast
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();

        // addMiddle
        ll.addmiddle(2, 9);
        ll.print();
        System.out.println(ll.size);

        // removeFirst
        ll.removeFirst();
        ll.print();
        System.out.println(ll.size);

        // removeLast
        ll.removeLast();
        ll.print();
        System.out.println(ll.size);

        // Find key using iteration O(n)
        ll.searchIterative(3);

        // finding key using recursion O(n)
        System.out.println(ll.recsearch(3));

        // reversal
        ll.reverse();
        ll.print();

        // remove nth from last
        ll.delete_Nth_From_End(1);
        ll.print();

        ll.removeFirst();
        ll.removeFirst();
        ll.print();

        // check if ll is palindrome or not
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();// 1->2->2->1
        System.out.println(ll.checkpalindrome());

    }

}
