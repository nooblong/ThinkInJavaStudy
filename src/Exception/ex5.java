package Exception;

public class ex5 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int reduce = -5;
        while (true){
            try{
                System.out.println("a[reduce] is "+ a[reduce]);
                System.out.println("success and break");
                break;
            }catch (ArrayIndexOutOfBoundsException x){
                System.out.println("now reduce is " + reduce);
                reduce++;
                System.out.println("after plus 1 is " + reduce);
            }
        }
    }
}
