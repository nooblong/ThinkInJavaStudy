package JavaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
import net.mindview.util.TextFile;
public class DirList3 {
    public static void main(String[] args) {
        String[] list;
        File path1 = new File(".");
        if (args.length == 0)
            list = path1.list();
        else
            list = path1.list(new DirFilter3(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
class DirFilter3 implements FilenameFilter{
    private Pattern pattern;
    public DirFilter3(String regex){
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
