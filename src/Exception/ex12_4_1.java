package Exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ex12_4_1 {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
    }
}
class LoggingException extends Exception{
    private static Logger logger =
            Logger.getLogger("LoggingException");//创建Logger对象
    public LoggingException(){
        StringWriter trace = new StringWriter();//为了获取String
        printStackTrace(new PrintWriter(trace));//
        logger.severe(trace.toString());
    }
}