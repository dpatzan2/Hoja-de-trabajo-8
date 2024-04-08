package uvg.edu.gt;

import junit.framework.TestCase;

public class VectorHeapTest extends TestCase {

    public void testParent() {
        VectorHeap<String> heap = new VectorHeap<>();
        assertEquals(-1, heap.parent(0));
        assertEquals(0, heap.parent(1));
        assertEquals(0, heap.parent(2));
        assertEquals(1, heap.parent(3));
        assertEquals(1, heap.parent(4));
        assertEquals(2, heap.parent(5));
    }

    public void testLeft() {
        VectorHeap<String> heap = new VectorHeap<>();
        assertEquals(1, heap.left(0));
        assertEquals(3, heap.left(1));
        assertEquals(5, heap.left(2));
        assertEquals(7, heap.left(3));
    }

    public void testRight() {
        VectorHeap<String> heap = new VectorHeap<>();
        assertEquals(2, heap.right(0));
        assertEquals(4, heap.right(1));
        assertEquals(6, heap.right(2));
        assertEquals(8, heap.right(3));
    }


    public void testAdd() {
        VectorHeap<String> heap = new VectorHeap<>();
        heap.add("C");
        heap.add("A");
        heap.add("B");
        assertEquals(3, heap.size());
    }

    public void testPushDownRoot() {
        VectorHeap<String> heap = new VectorHeap<>();
        heap.add("C");
        heap.add("A");
        heap.add("B");
        assertEquals("A", heap.remove());
    }

    public void testRemove() {
        VectorHeap<String> heap = new VectorHeap<>();
        heap.add("C");
        heap.add("A");
        heap.add("B");
        heap.remove();
        assertEquals(2, heap.size());
    }

    public void testIsEmpty() {
        VectorHeap<String> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());
        heap.add("C");
        assertFalse(heap.isEmpty());
    }

    public void testSize() {
        VectorHeap<String> heap = new VectorHeap<>();
        assertEquals(0, heap.size());
        heap.add("C");
        assertEquals(1, heap.size());
        heap.add("A");
        assertEquals(2, heap.size());
    }
}
