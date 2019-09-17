package Exception;

class LevelOneException extends Exception {}
class LevelTwoException extends LevelOneException {}
class LevelThreeException extends LevelTwoException {}

public class ex25 {
    public static void main(String[] args) {
        A1 a1 = new C1();
        try {
            a1.f1();
        } catch (LevelThreeException e3){
            System.out.println("Caught e3");
        } catch (LevelTwoException e2){
            System.out.println("catch e2");
        } catch (LevelOneException e1){
            System.out.println("catch e1");
        }
    }
}
class A1 {
    public void f1() throws LevelOneException{
        throw new LevelOneException();
    }
}
class B1 extends A1{
    public void f1() throws LevelTwoException{
        throw new LevelTwoException();
    }
}
class C1 extends B1{
    public void f1() throws LevelThreeException{
        throw new LevelThreeException();
    }
}
