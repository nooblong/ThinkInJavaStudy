package InnerClass.p2;

import InnerClass.p1.Ex6Interface;

public class Ex6Base {
    protected class Ex6BaseInner implements Ex6Interface{
        //need public constructor
        public Ex6BaseInner(){}
        @Override
        public String say() {
            return "Hi";
        }
    }
}
