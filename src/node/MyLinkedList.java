package node;

import field.Person;

public class MyLinkedList<E> {
    private Node<E> head = null;
    private int size = 0;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Node getNode(int index) {
        Node response = head;
        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }

    public void addFirst(E data) {
        head = new Node(head, data);
        size++;
    }

    private void add(E data, int index) {
        Node temp = getNode(index - 1);
        if (head == null) {
            addFirst(data);
        } else {
            Node newNode = temp.getNext();
            temp.setNext(new Node(newNode, data));
        }
        size++;
    }


    public void insert(E data, int index) {
        add(data, index);
    }


    public void insert(E data) {
        if (head == null) {
            addFirst(data);
        } else {
            add(data, size);
        }
    }

    public void delete(int index) {
        if (index == 0) {
            head = head.getNext();
        } else {
            Node temp = getNode(index - 1);
            Node nextNode = getNode(index);
            temp.setNext(nextNode.getNext());
        }
        size--;
    }


    public void delete() {
        delete(size - 1);
    }


    public void traverse() {
        Node temp = head;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(temp.getData() + (i < size - 1 ? "," : ""));
        }
        System.out.println("]");
    }


    public MyLinkedList<E> sort(MyLinkedList<E> person) {
        for (int i = 0; i < person.getSize(); i++) {
            for (int j = 1; j < person.getSize(); j++) {
                Node person1 = person.getNode(j - 1);
                Node person2 = person.getNode(j);
                Person first = (Person) person1.getData();
                Person second = (Person) person2.getData();
                if (first.getFirstName().compareTo(second.getFirstName()) >= 1) {
                    person.swap(person1, person2, j - 2);
                }
            }
        }
        return person;
    }

    private void swap(Node<E> first, Node<E> second, int previous) {
        if (first == head) {
            Node temp = second.getNext();
            head = second;
            second.setNext(first);
            first.setNext(temp);
        } else {
            Node temp = second.getNext();
            Node pre = getNode(previous);
            pre.setNext(second);
            second.setNext(first);
            first.setNext(temp);
        }

    }


}
