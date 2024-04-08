package uvg.edu.gt;

import java.util.ArrayList;
import java.util.List;

public class ManualPriorityQueue<E extends Comparable<E>> {
    private List<E> data;

    public ManualPriorityQueue() {
        data = new ArrayList<>();
    }

    public void add(E item) {
        data.add(item);
        int currentIndex = data.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (data.get(currentIndex).compareTo(data.get(parentIndex)) < 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public E poll() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola de prioridad está vacía");
        }
        E minItem = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        heapifyDown();
        return minItem;
    }

    private void heapifyDown() {
        int currentIndex = 0;
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int smallestChildIndex = currentIndex;
            if (leftChildIndex < data.size() && data.get(leftChildIndex).compareTo(data.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < data.size() && data.get(rightChildIndex).compareTo(data.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }
            if (smallestChildIndex != currentIndex) {
                swap(currentIndex, smallestChildIndex);
                currentIndex = smallestChildIndex;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
