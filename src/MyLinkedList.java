public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        if (tail != null) {
            tail.setNext(newNode);
        }
        Node<T> last = tail;
        tail = newNode;
        tail.setPrevious(last);
        size++;
    }

    public T get(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> currentNode = head;
        StringBuilder stringBuilder = new StringBuilder("[");
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                stringBuilder.append(currentNode.getData())
                        .append(", ");
                currentNode = currentNode.getNext();
            }
            stringBuilder.append(tail.getData());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return;
        }
        if (index + 1 == size) {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return;
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.getPrevious().setNext(currentNode.getNext());
        size--;
    }
}
