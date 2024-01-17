package pkgProject;

import java.util.ArrayList;

public class Node {
    protected Student data;
    protected Node next;
    protected Node prev;

    public Node() {
        data = null;
        next = null;
        prev = null;
    }

    public Node(Student d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }

    public void setLinkNext(Node n) {
        next = n;
    }

    public void setLinkPrev(Node p) {
        prev = p;
    }

    public Node getLinkNext() {
        return next;
    }

    public Node getLinkPrev() {
        return prev;
    }

    public void setData(Student d) {
        data = d;
    }

    public Student getData() {
        return data;
    }
}
