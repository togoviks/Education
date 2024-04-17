import java.util.Iterator;

public class MyArrayList implements Iterable<String> {
    private String[] array = new String[10];
    private int size = 0;

    public void add(String text) {
        if(array.length == size) {
            String[] newArray = new String[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = text;
        size++;
    }

    public String get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                stringBuffer.append(array[i])
                        .append(", ");
            }
            stringBuffer.append(array[size - 1]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public int findIndex(String text) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(text)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String text) {
        return findIndex(text) != -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public String next() {
            return array[currentIndex++];
        }
    }
}