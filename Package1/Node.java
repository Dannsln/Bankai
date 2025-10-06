package Package1;

public class Node {

    Car data;
    Node link;


    public Node(Car car){
        this.data = car;
        this.link = null;
    }

    public Node(Car car, Node next){
        super();
        this.data = car;
        this.link = next;
    }
}
