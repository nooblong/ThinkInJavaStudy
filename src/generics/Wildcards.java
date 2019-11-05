package generics;

public class Wildcards {
    static void rawArgs(Holder holder, Object arg){
        holder.set(arg);
        Object o = holder.get();
    }

    static void unboundedArg(Holder<?> holder, Object arg){
//        holder.set(arg);
        Object o = holder.get();
    }

    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg){
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg){
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg){
        holder.set(arg);
//        T t = holder.get();
        Object object = holder.get();
    }

    public static void main(String[] args) {
        Holder raw;
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unBounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long l = 1L;
        rawArgs(raw, l);
        rawArgs(qualified, l);
        rawArgs(unBounded, l);
        rawArgs(bounded, l);

        unboundedArg(raw, l);
        unboundedArg(qualified,l);
        unboundedArg(unBounded,l);
        unboundedArg(bounded, l);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unBounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, l);
        Long r6 = exact2(qualified, l);
//        Long r7 = exact2(unBounded, l);

    }

}
