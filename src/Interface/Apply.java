package Interface;
import java.util.Arrays;

abstract class StringProcessor implements Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
        Apply.process(new ChangeAdapter(new Change()),s);
    }
}
class Upcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Downcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}
class Splitter extends StringProcessor{
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}