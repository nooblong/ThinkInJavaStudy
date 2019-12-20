package enumerated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public enum OzWitch {
    WEST("Miss"),
    NORTH("Flinda"),
    EAST("Wicked" + "Slippers"),
    SOUTH("Good");

    private String des;

    private OzWitch(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values())
            System.out.println(witch + ": " + witch.getDes());

    }
}
