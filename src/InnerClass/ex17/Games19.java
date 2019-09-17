package InnerClass.ex17;

import java.util.Random;

interface Games {
    void play();
}

interface GamesFactory {
    Games getGames();
}

class CoinToss implements Games {
    Random rand = new Random();

    @Override
    public void play() {
        System.out.println("Toss coin: ");
        switch (rand.nextInt(2)) {
            case 0:
                System.out.println("Heads");
                return;
            case 1:
                System.out.println("Tails");
                return;
            default:
                System.out.println("OnEdge");
                return;
        }
    }

    public static GamesFactory getGames = new GamesFactory() {
        @Override
        public Games getGames() {
            return new CoinToss();
        }
    };
}

//class CoinTossFactory implements GamesFactory{
//
//    @Override
//    public Games getGames() {
//        return new CoinToss();
//    }
//}
class DiceThrow implements Games {
    Random rand = new Random();

    public void play() {
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }

    public static GamesFactory getGames = new GamesFactory() {
        @Override
        public Games getGames() {
            return new DiceThrow();
        }
    };
}

//class DiceThrowFactory implements GamesFactory {
//    public Games getGames() {
//        return new DiceThrow();
//    }
//}


public class Games19 {
    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(CoinToss.getGames);
        playGame(DiceThrow.getGames);
    }
}