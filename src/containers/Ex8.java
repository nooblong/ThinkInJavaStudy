package containers;

class Node<E>{
    E e;
    Node<E> next;
    Node(E e, Node<E> next){
        this.e = e;
        this.next = next;
    }
    Node(E e){
        this(e,null);
    }

    @Override
    public String toString() {
        if (e == null)
            return "null";
        return e.toString();
    }
}

class SListIterator<E>{
    private Node<E> current;
    SListIterator(Node<E> current){
        this.current = current;
    }
    public boolean hasNext(){
        return current.next != null;
    }
    public Node<E> next(){
        current = current.next;
        return current;
    }
    public void insert(E e){
        current.next = new Node<>(e,current.next);
        current = current.next;
    }
    public void remove(){
        if (current.next == null){
            current.next = current.next.next;
        }
    }
}

class SList<T>{
    private Node<T> head = new Node<T>(null);
    SListIterator<T> iterator(){
        return new SListIterator<>(head);
    }

    @Override
    public String toString() {
        if (head.next == null){
            return "SList: []";
        }
        System.out.print("SList: [");
        SListIterator<T> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()){
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}
class Ex8{
    public static void main(String[] args) {
        SList<String> sl = new SList<>();
        System.out.println(sl);
        SListIterator<String> sli = sl.iterator();
        sli.insert("there");
        sli.insert("fuck");
        System.out.println(sl);
    }
}