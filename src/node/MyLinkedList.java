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
}
