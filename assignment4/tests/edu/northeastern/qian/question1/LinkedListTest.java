package edu.northeastern.qian.question1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListTest {

    @Test
    void testThreadSafe_addingAtTheSameTime() throws InterruptedException {
        LinkedList list = new LinkedList();
        long start = System.currentTimeMillis();

        int N1 = 20000000;
        int N2 = 20000000;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N1; i++) {
                    list.addAtPosition(0, 1);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N2; i++) {
                    list.addAtPosition(0, 2);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long elapsedTime = System.currentTimeMillis() - start;
        assertTrue(validateLinkedList(list));
        assertEquals(N1 + N2, list.size());
        System.out.println("time elapsed: " + elapsedTime);
    }

    @Test
    void testThreadSafe_addingAndRemovingAtTheSameTime() throws InterruptedException {
        LinkedList list = new LinkedList();
        long start = System.currentTimeMillis();

        int N1 = 20000000;
        int N2 = 20000000;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N1; i++) {
                    list.addAtPosition(0, 1);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N2; i++) {
                    try {
                        list.removeAtPosition(0);
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long elapsedTime = System.currentTimeMillis() - start;
        assertTrue(validateLinkedList(list));
        System.out.println("time elapsed: " + elapsedTime);
    }

    @Test
    void testCreation() {
        assertTrue(validateLinkedList(new LinkedList()));
    }

    @Test
    void addAtPosition_test1() {
        LinkedList list = createTestLinkedList();
        validateLinkedList(list, new int[]{1, 3, 4, 2});
    }

    @Test
    void addAtPosition_test2_addToHeadAndTail() {
        LinkedList list = new LinkedList();
        list.addAtPosition(0, 1);
        list.addAtPosition(1, 2);
        list.addAtPosition(1, 3);
        list.addAtPosition(2, 4);
        list.addAtPosition(0, 5);
        list.addAtPosition(5, 7);
        validateLinkedList(list, new int[]{5, 1, 3, 4, 2, 7});
    }

    @Test
    void removeAtPosition_removeHead() {
        // 1, 3, 4, 2
        LinkedList list = createTestLinkedList();
        list.removeAtPosition(0);
        validateLinkedList(list, new int[]{3, 4, 2});
    }

    @Test
    void removeAtPosition_removeTail() {
        // 1, 3, 4, 2
        LinkedList list = createTestLinkedList();
        list.removeAtPosition(3);
        validateLinkedList(list, new int[]{1, 3, 4});
    }

    @Test
    void removeAtPosition_removeMiddle() {
        // 1, 3, 4, 2
        LinkedList list = createTestLinkedList();
        list.removeAtPosition(2);
        validateLinkedList(list, new int[]{1, 3, 2});
    }

    @Test
    void getFirst() {
        // 1, 3, 4, 2
        LinkedList list = createTestLinkedList();
        int first = list.getFirst();
        assertEquals(1, first);
    }

    @Test
    void getFirst_emptyList() {
        LinkedList emptyList = new LinkedList();
        int first = emptyList.getFirst();
        assertEquals(-1, first);
    }

    @Test
    void getLast() {
        // 1, 3, 4, 2
        LinkedList list = createTestLinkedList();
        int last = list.getLast();
        assertEquals(2, last);
    }

    @Test
    void getLast_emptyList() {
        LinkedList emptyList = new LinkedList();
        int last = emptyList.getLast();
        assertEquals(-1, last);
    }

    @Test
    void size_zero() {
        LinkedList list = createTestLinkedList();
        assertEquals(4, list.size());
    }

    @Test
    void size() {
        LinkedList emptyList = new LinkedList();
        assertEquals(0, emptyList.size());
    }

    private boolean validateLinkedList(LinkedList list) {
        if (list.size() == 0) {
            return list.head == null && list.tail == null;
        }
        ListNode cur = list.head;
        for (int i = 0; i < list.size() - 1; i++) {
            cur = cur.next;
        }
        return cur == list.tail && list.tail.next == null;
    }

    private boolean validateLinkedList(LinkedList list, int[] arr) {
        if (!validateLinkedList(list)) {
            return false;
        }
        if (list.size() != arr.length) {
            return false;
        }
        ListNode cur = list.head;
        for (int i = 0; i < arr.length; i++) {
            if (cur.val != arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1, 3, 4, 2
     * @return
     */
    private LinkedList createTestLinkedList() {
        LinkedList newList = new LinkedList();
        newList.addAtPosition(0, 1);
        newList.addAtPosition(1, 2);
        newList.addAtPosition(1, 3);
        newList.addAtPosition(2, 4);
        return newList;
    }
}