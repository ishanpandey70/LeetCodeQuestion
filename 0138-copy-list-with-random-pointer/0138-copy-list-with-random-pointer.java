/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }
        Node newHead = new Node(head.val);
        Node node = head;
        Node current = newHead;
        HashMap<Node, Node>  h = new HashMap<>();
        h.put(head, newHead);
        while(node.next!=null)
        {
            node = node.next;
            current.next = new Node(node.val);
            current = current.next;
            h.put( node,current);


        }
        node = head;
        current = newHead;
        if(node.random != null)
        current.random = h.get(node.random);
    //    System.out.println(h);
       
        while(node.next!=null)
        {
            node = node.next;
            // if(current.next == null )
            // {
            //     System.out.println("Something wrong in copying");
            //     break;
            // }
            current = current.next;
            if( node.random != null)
            {

            current.random = h.get(node.random);
            }
            else current.random = null;
            


        }
        return newHead;
    }
}