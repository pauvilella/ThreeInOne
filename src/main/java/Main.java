import java.util.NoSuchElementException;

public class Main {
    private static class ThreeStacksArray {
        private int head1 = 0;
        private int tail1 = 0;
        private int items1 = 0;
        private int head2 = 1;
        private int tail2 = 1;
        private int items2 = 0;
        private int head3 = 2;
        private int tail3 = 2;
        private int items3 = 0;

        private int offset = 3;

        public int[] array = new int[10];

        public void push(int stack, int data) {
            int tail;
            int head;
            switch (stack) {
                case 1:
                    items1++;
                    head = head1;
                    tail = tail1;
                    tail1 = tail1 + offset;
                    break;
                case 2:
                    items2++;
                    head = head2;
                    tail = tail2;
                    tail2 = tail2 + offset;
                    break;
                case 3:
                    items3++;
                    head = head3;
                    tail = tail3;
                    tail3 = tail3 + offset;
                    break;

                default:
                    throw new NoSuchElementException();
            }

            for (int i = tail; i > head; i = i - offset) {
                array[i] = array[i - offset];
            }
            array[head] = data;
        }

        public int peek(int stack) {
            int item;
            switch (stack) {
                case 1:
                    item = array[head1];
                    break;
                case 2:
                    item = array[head2];
                    break;
                case 3:
                    item = array[head3];
                    break;

                default:
                    throw new NoSuchElementException();
            }
            return item;
        }

        public int pop(int stack) {
            int item = peek(stack);
            int head, tail;
            switch (stack) {
                case 1:
                    items1--;
                    head = head1;
                    tail = tail1;
                    tail1 = tail1 - offset;
                    break;
                case 2:
                    items2--;
                    head = head2;
                    tail = tail2;
                    tail2 = tail2 - offset;
                    break;
                case 3:
                    items3--;
                    head = head3;
                    tail = tail3;
                    tail3 = tail3 - offset;
                    break;
                default:
                    throw new NoSuchElementException();
            }
            for (int i = head; i < tail; i++) {
                array[i] = array[i + offset];
            }
            return item;
        }

        public boolean isEmpty(int stack) {
            int items;
            switch (stack) {
                case 1:
                    items = items1;
                    break;
                case 2:
                    items = items2;
                    break;
                case 3:
                    items = items3;
                    break;
                default:
                    throw new NoSuchElementException();
            }
            return items == 0;
        }
    }

    public static void main(String[] args) {
        ThreeStacksArray stacks = new ThreeStacksArray();
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(2, 2);
        stacks.push(2, 2);
        stacks.push(2, 2);
        stacks.push(3, 3);
        stacks.push(3, 3);
        stacks.push(3, 3);
        for (int i : stacks.array) {
            System.out.println(i);
        }
        System.out.println("");
        System.out.println(stacks.items1);
        System.out.println(stacks.items2);
        System.out.println(stacks.items3);
    }
}
