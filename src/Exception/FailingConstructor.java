package Exception;

public class FailingConstructor{
    private int array[] = {1,2,3};
    FailingConstructor(int i) throws Exception{
        System.out.println(array[i]);
    }

    public static void main(String[] args) {
        try {
            FailingConstructor f = new FailingConstructor(3);
        } catch (Exception e){
            System.out.println("输入错误");
            e.printStackTrace();
        }
    }
}
