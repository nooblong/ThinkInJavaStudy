package enumerated;

import net.mindview.util.Enums;

import java.util.EnumMap;

public enum  RoShamBo5 {
    PAPER, SCISSORS, ROCK;
    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values()){
            table.put(it, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }
        initRow(PAPER, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
        initRow(SCISSORS, Outcome.WIN, Outcome.DRAW, Outcome.LOSE);
        initRow(ROCK, Outcome.LOSE, Outcome.WIN, Outcome.DRAW);
    }

    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK){
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    public Outcome compete(RoShamBo5 it){
        return table.get(this).get(it);
    }

    public static void match(RoShamBo5 a, RoShamBo5 b){
        System.out.println(a + " vs " + b + ": " + a.compete(b) );
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            match(Enums.random(RoShamBo5.class), Enums.random(RoShamBo5.class));
        }
    }
}
