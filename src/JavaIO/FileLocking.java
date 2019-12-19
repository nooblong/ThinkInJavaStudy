package JavaIO;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null){
            System.out.println("locked file");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("release ok");
        }
        fos.close();
    }
}
