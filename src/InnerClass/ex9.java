package InnerClass;

interface Ex9interface{
    void say(String s);
}
class Ex9{
    Ex9interface f(){
        class Inner implements Ex9interface{

            @Override
            public void say(String s) {
                System.out.println(s);
            }
        }
        return new Inner();
    }

    public static void main(String[] args) {
        Ex9 ex9 = new Ex9();
        ex9.f().say("hihihi");
    }
}