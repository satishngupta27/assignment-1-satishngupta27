package node;

public class MyLinkedList<E> {
    private Node<E> head = null;
    private int size = 0;

    public void setSize(int size) {
        this.size = size;
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

    @Override
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


}
