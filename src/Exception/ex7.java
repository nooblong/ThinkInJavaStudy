package Exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ex7 {
}

 class Ex3 {
    private static int[] ia = new int[2];
    private static Logger logger = Logger.getLogger("Fuck");
    static void logExcption(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch(ArrayIndexOutOfBoundsException e) {
            logExcption(e);
        }
    }
}