package annotations;

import JavaIO.OSExecute;
import net.mindview.util.*;
import net.mindview.atunit.AtUnit.*;


public class AtUnitExample1 {
    public String methodOne(){
        return "This is methodOne";
    }
    public int methodTwo(){
        return 2;
    }

    @Test boolean methodOneTest(){
        return methodOne().equals("This is methodOne");
    }

    @Test boolean m2(){
        return methodTwo() == 2;
    }

    @Test private boolean m3(){
        return true;
    }

    @Test boolean failureTest(){
        return false;
    }

    @Test boolean anotherDisappointment(){
        return false;
    }

    public static void main(String[] args) {
        OSExecute.command("java net.mindview.atunit.AtUnit out/production/ThinkInJavaStudy/annotations/AtUnitExample1");
    }
}
