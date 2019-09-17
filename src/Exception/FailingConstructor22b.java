package Exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FailingConstructor22b {
    private BufferedReader in;
    public FailingConstructor22b(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e){
            try {
                in.close();
            } catch (IOException e2){
                System.out.println("in.close() failed");
            }
            throw e;
        }
    }
    public String getLine(){
        String s;
        try {
            s = in.readLine();
        } catch (IOException e){
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }
    public void dispose(){
        try{
            in.close();
            System.out.println("Dispose() successful");
        } catch (IOException e){
            throw new RuntimeException("in.close() failed");
        }
    }

    public static void main(String[] args) {
        try {
            FailingConstructor22b fc =
                    new FailingConstructor22b("AlwaysFinally.java");
            try {
                String s;
                int i = 1;
                while ((s = fc.getLine()) != null){
                    System.out.println(i + " " + s);
                }
            } catch (Exception e){
                System.out.println("Exception caught in main()");
                e.printStackTrace();
            } finally {
                fc.dispose();
            }
        } catch (Exception e){
            System.out.println("FailingConstructor22b");
        }
    }
}
