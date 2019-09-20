//package test;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.GenericArrayType;
//import java.lang.reflect.Modifier;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.lang.reflect.TypeVariable;
//import java.lang.reflect.WildcardType;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author zhangquanit
// */
//public class ConstructorTest<T> {
//
//    private List<T> mList;
//    private T[] mParams;
//
//    public ConstructorTest(){
//
//    }
//    public ConstructorTest(List<T> list, T... params)
//            throws RuntimeException, Exception {
//        this.mList = list;
//        this.mParams = params;
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        // 获取构造函数
//        Constructor<ConstructorTest> constructor = ConstructorTest.class
//                .getDeclaredConstructor(List.class, Object[].class);
//        if (!constructor.isAccessible()) {
//            constructor.setAccessible(true);
//        }
//        // 构造函数信息
//        constructorInfo(constructor);
//
//        // 创建实例
//        List<String> arrayList = new ArrayList<String>();
//        arrayList.add("1");
//        arrayList.add("2");
//        ConstructorTest instance = constructor.newInstance(arrayList,
//                new String[] { "2", "2" });
//        List<String> list=instance.mList; //[1,2]
//        String[] mParams=(String[]) instance.mParams;//[2,2]
//
//        //默认构造方法创建实例
//        Constructor<ConstructorTest> defaultConstructor= ConstructorTest.class.getDeclaredConstructor();
//        ConstructorTest instance2=defaultConstructor.newInstance();
//
//        //构造函数所在的类
//        Class<ConstructorTest> declaringClass = constructor.getDeclaringClass();
//        //如果此构造方法是一个复合构造方法，则返回 true
//        boolean synthetic = constructor.isSynthetic(); //false
//        //构造方法参数中是否包含可变参数
//        boolean varArgs = constructor.isVarArgs(); //true
//    }
//
//    private static void constructorInfo(Constructor constructor) {
//        // 1、注解
//        boolean annotationPresent = constructor
//                .isAnnotationPresent(MyAnnotation.class);
//        if (annotationPresent) {
//            MyAnnotation myAnnotation = constructor
//                    .getDeclaredAnnotation(MyAnnotation.class);
//        }
//        Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
//
//        // 2.修饰符
//        int modifiers = constructor.getModifiers();
//        String modify = Modifier.toString(modifiers);// public transient
//
//        // 3、定义在构造方法上的泛型
//        TypeVariable[] typeParameters = constructor.getTypeParameters();
//        System.out.println(Arrays.toString(typeParameters));
//
//        // 4、构造方法名
//        String name = constructor.getName();// reflect.ConstructorTest
//
//        // 5、构造方法参数
//        int parameterCount = constructor.getParameterCount();
//        // 方法参数类型
//        Class<?>[] parameterTypes = constructor.getParameterTypes();
//        // 打印 [interface java.util.List, class [Ljava.lang.Object;]
//        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
//        // 打印 [java.util.List<T>, T[]]
//        for (Type type : genericParameterTypes) {
//            if (type instanceof ParameterizedType) { // 参数类型
//                System.out.println("ParameterizedType类型：" + type);
//                ParameterizedType parameterizedType = (ParameterizedType) type;
//                Type[] actualTypeArguments = parameterizedType
//                        .getActualTypeArguments();
//                System.out.println("实际参数为："
//                        + Arrays.toString(actualTypeArguments));
//                for (Type actualType : actualTypeArguments) {
//                    if (actualType instanceof WildcardType) {
//                        WildcardType wildcardType = (WildcardType) actualTypeArguments[0];
//                        System.out.println("实际参数为WildcardType类型："
//                                + wildcardType.getUpperBounds());
//                    } else if (actualType instanceof Class) {
//                        System.out.println("实际参数为Class类型：" + actualType);
//                    }
//                }
//
//            } else if (type instanceof GenericArrayType) { // 泛型数组类型 T[]
//                GenericArrayType genericArrayType = (GenericArrayType) type;
//                System.out.println("GenericArrayType类型："
//                        + genericArrayType.getGenericComponentType());// T
//            } else if (type instanceof TypeVariable) { // 泛型变量
//                System.out.println("TypeVariable类型：" + type);
//            } else if (type instanceof Class) { //
//                System.out.println("Class类型：" + type);
//            }
//        }
//        /*
//         * 方法有2个参数，第一个参数list为ParameterizedType，实际参数为T，
//         * 第二个参数为GenericArrayType泛型数组类型T[],数组元素类型为T
//         */
//
//        // 方法参数——注解 第一个参数使用了注解
//        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
//        Annotation myAnnotation = parameterAnnotations[0][0];
//        // 打印 @reflect.MyAnnotation(intValue=0)
//
//        // 6、方法抛出的异常
//        Class<?>[] exceptionTypes = constructor.getExceptionTypes();
//        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]
//        Type[] genericExceptionTypes = constructor.getGenericExceptionTypes();
//        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]
//    }
//}
//
