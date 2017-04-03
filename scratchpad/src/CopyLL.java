import java.util.*;

public class CopyLL {

    public static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    // Shallow copy a list of nodes from a LinkedList
    public static LinkedList<Node> shallowCopy(LinkedList<Node> list) {
        return list;
    }

    // Deep copy a list of nodes from a LinkedList
    public static LinkedList<Node> deepCopy(LinkedList<Node> list) {
        LinkedList<Node> res = new LinkedList<>();
        ListIterator<Node> it = list.listIterator();
        while (it.hasNext()) {
            res.add(new Node(it.next().val));
        }
        return res;
    }

    public static void printLL(LinkedList<Node> list) {
        ListIterator<Node> it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next().val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Node> test = new LinkedList<>(Arrays.asList(new Node(1), new Node(2), new Node(3)));

        LinkedList<Node> shallow = shallowCopy(test);
        LinkedList<Node> deep = deepCopy(test);

        printLL(shallow);
        printLL(deep);
    }
}
