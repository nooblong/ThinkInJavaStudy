package Interface;

public class DiamondInheritance13 {
    public static void main(String[] args) {
        Doer d = new Doer();
        ((CanDoMore)d).doMore();
    }
}
interface CanDo{
    void doIt();
}
interface CanDoMore extends CanDo{
    void doMore();
}
interface CanDoFaster extends CanDo{
    void doFaster();
}
interface CanDoMost extends CanDoFaster, CanDoMore{
    void doMost();
}
class Doer implements CanDoMost{
    public void doIt() {}
    public void doMore() {}
    public void doFaster() {}
    public void doMost() {}
}