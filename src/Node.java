public class Node {
    Node prev;
    Sword item;
    Node next;
    public Node (Node prevPassed, Sword itemPassed, Node nextPassed) {
        prev = prevPassed;
        item = itemPassed;
        next = nextPassed;
    }
}
