package codeWarsJava.dataStructures;

import javax.annotation.concurrent.Immutable;

@Immutable
public class Node {

  public int data;
  public Node next = null;

  public Node(final int data) {
    this.data = data;
  }

  public static Node push(final Node head, final int data) {
    if (head == null) {
      return new Node(data);
    } else if (head != null) {
      head.next = new Node(data);
    }
    head.next.next = null; // I don't think I'm supposed to set this here, but it's good to know how to do.
    return head;
  }

  public static Node buildOneTwoThree() {
    final Node oneTwoThree = Node.push(null, 1);
    Node.push(oneTwoThree, 2);
    Node.push(oneTwoThree, 3);
    return oneTwoThree;
  }
}