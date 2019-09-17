package Exception;

class ep1 extends Exception {
}

class ep2 extends Exception {
}

public class trst {
    public static void main(String[] args) throws Throwable {
        try {
            try {
                throw new ep1();
            } catch (ep1 e) {
                throw e;//.fillInStackTrace();
            }
        } catch (ep1 e){
            e.getStackTrace();
            e.getCause();
        }
    }
}
