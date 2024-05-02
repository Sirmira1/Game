public class Node {
    Node prev;
    String item;
    Node next;
    public Node (Node prevPassed, String itemPassed, Node nextPassed) {
        prev = prevPassed;
        item = itemPassed;
        next = nextPassed;
    }
}
