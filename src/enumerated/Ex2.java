package enumerated;

import net.mindview.util.Generator;

import java.util.Random;

enum CartoonCharactor2 {

    SLAPPY, SPANKY, PUNCHY, SILLY
    ;

    public static Random random = new Random(47);

    public static CartoonCharactor2 next(){
        return values()[random.nextInt(values().length)];
    }

    public static void main(String[] args) {
        CartoonCharactor2 cc2 = CartoonCharactor2.SILLY;
        for (int i = 0; i < 10; i++) {
            System.out.println(CartoonCharactor2.next());
            System.out.print((i<9) ? ", " : " ");
        }
    }
}
