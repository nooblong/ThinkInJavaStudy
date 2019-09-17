package InnerClass;

interface I{
    Inner getInner();
    class Inner implements I{

        @Override
        public Inner getInner() {
            return new Inner();
        }
        public void hi(){
            System.out.println("hi");
        }

        public static void main(String[] args) {
            I.Inner in = new I.Inner();
            in.hi();
            Inner a = in.getInner();
            a.hi();
        }
    }
}