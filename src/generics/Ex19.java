package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Poison {
    private final int id;
    private String description;
    private double price;

    public Poison(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
    public static Generator<Poison> generator =
            new Generator<Poison>() {
                private Random random = new Random(47);

                @Override
                public Poison next() {
                    return new Poison(random.nextInt(1000), "New Poison",
                            Math.round(random.nextDouble() * 1000.0 + 0.99));
                }
            };
}

class Container extends ArrayList<Poison> {
    Container(int nPoison){
        Generators.fill(this,Poison.generator,nPoison);
    }
} 

class Area extends ArrayList<Container>{
    Area(int nContainer, int nPoison){
        for (int i = 0; i < nContainer; i++) {
            this.add(new Container(nPoison));
        }
    }
}

class Ship extends ArrayList<Area>{
    public Ship(int nArea, int nContainer, int nPoison){
        for (int i = 0; i < nArea; i++) {
            this.add(new Area(nContainer, nPoison));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Area a : this){
            for (Container c : a){
                for (Poison p : c){
                    builder.append(p);
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Ship(4,5,6));
    }
}
