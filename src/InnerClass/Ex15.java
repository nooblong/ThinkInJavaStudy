package InnerClass;

public class Ex15 {
    String s;
    Ex15(String s){
        this.s = s;
    }

}
class Tmp{
    public Ex15 makeEx15(){
        return new Ex15("nihao"){ };
    }

    public static void main(String[] args) {
        Tmp t = new Tmp();
        System.out.println(t.makeEx15().s);
    }
}
