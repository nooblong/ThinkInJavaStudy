package annotations.database;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Command {

    static Runtime runtime = Runtime.getRuntime();
    public static void exeCmd(String commandStr) {
        BufferedInputStream bis = null;
        try {
            Process p = runtime.exec("mysql -uroot -p123456");
//            synchronized (runtime)
            runtime.wait();
            bis = new BufferedInputStream(p.getInputStream());
            StringBuilder sb = new StringBuilder();
            String line = null;
            byte[] bytes = bis.readAllBytes();
            sb.append(new String(bytes, Charset.forName("GBK"))).append("\n");
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        Command.exeCmd("ping baidu.com");
        String commandStr = "mysql -uroot -p123456";
        Command.exeCmd(commandStr);
        Command.exeCmd("show databases;");
    }
}
