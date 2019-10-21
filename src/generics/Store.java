//package generics;
//
//import net.mindview.util.Generator;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//
//class Product {
//    private final int id;
//    private String description;
//    private double price;
//
//    public Product(int id, String description, double price) {
//        this.id = id;
//        this.description = description;
//        this.price = price;
//        System.out.println(toString());
//    }
//
//    @Override
//    public String toString() {
//        return id + ": " + description + ", price: $" + price;
//    }
//
//    public void changePrice(double change) {
//        price += change;
//    }
//
//    public static Generator<Poison> generator =
//            new Generator<Poison>() {
//                private Random random = new Random(47);
//
//                @Override
//                public Poison next() {
//                    return new Poison(random.nextInt(1000), "Test",
//                            Math.round(random.nextDouble() * 1000.0 + 0.99));
//                }
//            };
//}
//    class Shelf extends ArrayList<Poison> {
//        public Shelf(int nProducts) {
//            Generators.fill(this, Poison.generator, nProducts);
//        }
//    }
//
//    class Aisle extends ArrayList<Shelf> {
//        public Aisle(int nShelves, int nProducts) {
//            for (int i = 0; i < nShelves; i++) {
//                add(new Shelf(nProducts));
//            }
//        }
//    }
//
//    class CheckoutStand {
//    }
//
//    class Office {
//    }
//
//    public class Store extends ArrayList<Aisle> {
//        private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
//        private Office office = new Office();
//
//        public Store(int nAisles, int nShelves, int nProducts) {
//            for (int i = 0; i < nAisles; i++) {
//                add(new Aisle(nShelves, nProducts));
//            }
//        }
//
//        @Override
//        public String toString() {
//            StringBuilder result = new StringBuilder();
//            for (Aisle a : this) {
//                for (Shelf s : a) {
//                    for (Poison p : s) {
//                        result.append(p);
//                        result.append("\n");
//                    }
//                }
//            }
//            return result.toString();
//        }
//
//        public static void main(String[] args) {
//            System.out.println(new Store(14,5,10));
//        }
//    }
//
