package generics.lol;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;

public class LeagueGenerator implements Gen<League> {

    Class[] types = {Ashe.class, Galen.class, Teemo.class, Ryze.class};

    Random random = new Random(47);

    private int size = 0;

    public LeagueGenerator(){}
    public LeagueGenerator(int m){
        size = m;
    }
    @Override
    public League next() {
        try {
            return (League) (types[random.nextInt(types.length)]).getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    class LeagueIterator implements Iterator<League>{
        int count = size;
        public boolean hasNext(){return count > 0;}

        @Override
        public League next() {
            count--;
            return LeagueGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new RuntimeException();
        }
    }
    public Iterator<League> iterator(){
        return new LeagueIterator();
    }

    public static void main(String[] args) {
        LeagueGenerator leagueGenerator = new LeagueGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(leagueGenerator.next());
        }
    }
}
