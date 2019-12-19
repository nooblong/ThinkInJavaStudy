package JavaIO;

import java.util.prefs.*;
import static net.mindview.util.Print.*;
import java.io.*;

public class Ex33 {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences
                .userNodeForPackage(Ex33.class);
        int value = prefs.getInt("base directory", 0);
        System.out.print("Base directory value = " + value +
                "\nEnter new base directory value (integer): ");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            value = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        prefs.putInt("base directory", value);
    }
}
