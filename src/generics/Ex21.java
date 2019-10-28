package generics;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class Building {
}

class House extends Building {
}

class ClassTypeCapture<T> {
    private Class<T> kind;

    private ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    private ClassTypeCapture(Class<T> kind, Map<String, Class<?>> classMap) {
        this.kind = kind;
        this.map = classMap;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    private Map<String, Class<?>> map;

    private void addType(String name, Class<?> kind){
        map.put(name,kind);
    }

    private Object createNew(String typeName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (map.containsKey(typeName)){
            return map.get(typeName).getDeclaredConstructor().newInstance();
        } else {
            System.out.println("class " + typeName + " not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building1> ctt1 =
                new ClassTypeCapture<Building1>(Building1.class);
        System.out.println(ctt1.f(new Building1()));
        System.out.println(ctt1.f(new House1()));
        ClassTypeCapture<House1> ctt2 =
                new ClassTypeCapture<House1>(House1.class);
        System.out.println(ctt2.f(new Building1()));
        System.out.println(ctt2.f(new House1()));

        ClassTypeCapture<Building1> ct = new ClassTypeCapture<>(Building1.class, new HashMap<>());

        ct.addType("House", House1.class);
        ct.addType("Building", Building1.class);
        try {
            Building1 b = (Building1)ct.createNew("Building");
            House1 h = (House1)ct.createNew("House");
            System.out.println("b.getClass().getName(): ");
            System.out.println(b.getClass().getName());
            System.out.println("h.getClass().getName(): ");
            System.out.println(h.getClass().getName());
            System.out.println("House h is instance House: ");
            System.out.println(h instanceof House1);
            System.out.println("House h is instance of Building: ");
            System.out.println(h instanceof Building1);
            System.out.println("Building b is instance of House: ");
            System.out.println(b instanceof House1);
            ct.createNew("String");  // String class not available
        } catch(IllegalAccessException e) {
            System.out.println("IllegalAccessException in main");
        } catch(InstantiationException e) {
            System.out.println("InstantiationException in main");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
