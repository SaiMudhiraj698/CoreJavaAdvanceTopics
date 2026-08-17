package ReflectionInJava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessMethods {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,NoSuchMethodException, IllegalAccessException {
        Calculator calculator = new Calculator();
//        System.out.println(calculator.add(10,20)); // we can;'t acces method because add method is private


             // Reflection


        Class<?> clazz = Calculator.class;
        Method method=clazz.getDeclaredMethod("add", int.class, int.class); // int.class means integer we are passing
        method.setAccessible(true);
        int ans= (int) method.invoke(calculator,10,40);
        System.out.println(ans);
    }
}
