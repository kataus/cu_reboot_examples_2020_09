package ru.sbrf.cu.reflection;

/**
 * @author sergey
 * created on 30.11.18.
 */
public class ReflectionIntro {
    public static void main(String[] args) throws ClassNotFoundException {
        String utem  = "test";
        Class<?> classString = Class.forName("java.lang.String");
        System.out.println("simpleName:" + classString.getSimpleName());
        System.out.println("canonicalName:" + classString.getCanonicalName());

        Class<Integer> classInt = int.class;
        System.out.println("TypeName int:" + classInt.getTypeName());
        System.out.println("TypeName int:" + classInt.getCanonicalName());

        Class<Integer> classInteger = Integer.class;
        System.out.println("TypeName integer:" + classInteger.getTypeName());
        System.out.println("TypeName integer:" + classInteger.getCanonicalName());

    }
}
