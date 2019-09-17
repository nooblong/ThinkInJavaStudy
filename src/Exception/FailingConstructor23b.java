package Exception;

/*在上一练习中添加一个带有dispose（）方法的类。修改
        * FailingConstructor，以便构造函数创建这些一次性对象
        *中的一个作为成员对象，之后构造函数可能会抛出异常，之后
        会创建第二个可处理成员对象。编写代码以正确防范
        *以防止失败，并在main（）中验证是否涵盖了所有可能的故障情况。
        */
import java.io.*;

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

public class FailingConstructor23b {
    private BufferedReader in;
    NeedsCleanup nc1;
    NeedsCleanup nc2;
    public FailingConstructor23b(String fname) throws Exception {
        nc1 = new NeedsCleanup();
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch(FileNotFoundException e) {
            System.out.println("Could not find file " + fname);
            throw e;
        } catch(Exception e) {
            try {
                in.close();
            } catch(IOException e2) {
                System.out.println("in.close() failed");
            }
            throw e;
        }
        nc2 = new NeedsCleanup();
    }
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch(IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }
    public static void main(String[] args) {
        try {
            FailingConstructor23b fc =
                    new FailingConstructor23b("AlwaysFinallya.java");
            try {
                String s;
                int i = 1;
                while((s = fc.getLine()) != null) {
                    System.out.println(s);
                }
            } catch(Exception e) {
                System.out.println("Exception caught in main()");
                e.printStackTrace(System.err);
            } finally {
                fc.nc1.dispose();
                fc.nc2.dispose();
            }
        } catch(Exception e) {
            System.out.println("FailingConstructor23b construction failed");
        }
    }
}
