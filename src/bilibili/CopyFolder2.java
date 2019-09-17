package bilibili;

import java.io.*;

public class CopyFolder2 {
    public static void main(String[] args) {
        copyDir(new File("./test"), new File("./test2"));
//        for (String s: new File("./src").list()) {
//            System.out.println(s);
//        }
    }

    public static void copyDir(File oldFile, File newFile) {
        if (oldFile.isDirectory()){
            newFile.mkdir();
            File[] files = oldFile.listFiles();
            for (File f : files){
                copyDir(f, new File(newFile, f.getName()));
            }
        } else if (oldFile.isFile()){
            File file3 = new File(newFile.getAbsolutePath());
            try {
                file3.createNewFile();
                copyFile(oldFile.getAbsolutePath(), file3.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        try (FileInputStream in = new FileInputStream(oldFile);
             FileOutputStream out = new FileOutputStream(file)) {
            byte[] buffer = new byte[1];
            int readByte;
            while ((readByte = in.read(buffer)) != -1) {
                out.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
