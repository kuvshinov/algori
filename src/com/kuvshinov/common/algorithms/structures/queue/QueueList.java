package com.kuvshinov.common.algorithms.structures.queue;

public class QueueList<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public boolean add(T value) {
        if (value == null) throw new NullPointerException();
        if (head == null) {
            head = new Node<>(value);
            last = head;
        } else {
            last.next = new Node<>(value);
            last = last.next;
        }
        size++;
        return true;
    }

    /**
     * Remove specific object.
     * You can use additional variable <code>prev</code> for storing previous node, then code will be:
     * <code>
     *     Node next = head;
     *     Node prev = null;
     *     while (next != null) {
     *         if (o.equals(next.value) {
     *             if (prev == null) {
     *                 head = head.next;
     *                 size--; return true;
     *             }
     *             prev.next = next.next;
     *             size--; return true;
     *         } else {
     *             prev = next;
     *             next = next.next;
     *         }
     *     }
     * </code>
     * It looks more better but need additional memory (it is important in some interviews).
     * @param o - value that must be deleted.
     * @return <code>true</code> if element was removed.
     */
    public boolean remove(T o) {
        if (size == 0) return false;
        Node next = head;
        if (o.equals(next.value)) {
            head = head.next;
            size--;
            return true;
        }
        while(next.next != null) {
            if (o.equals(next.next.value)) {
                next.next = next.next.next;
                size--;
                return true;
            } else {
                next = next.next;
            }
        }
        return false;
    }

    public T remove() {
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> next = head;
        for (int i = 0; i < index; i++) {
            next = next.next;
        }
        return next.value;
    }

    public T get() {
        return head.value;
    }

    public int size() {
        return size;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        QueueList<Integer> list = new QueueList<>();
        for (int i = 0; i < 10; i++) {
            list.add(9 - i);
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        list.remove(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
