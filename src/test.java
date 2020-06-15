import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws Exception {
        while (true) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(1000);
        }
    }
}
