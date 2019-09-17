package bilibili;

import java.io.File;

public class CopyFolder {
    public static void printName(File src) {
        System.out.println(src.getName());
        if (src == null || !src.exists()) {
            return;
        } else if (src.isDirectory()){
            for (File s : src.listFiles()){
                printName(s);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("./");
        printName(file);

    }
}
