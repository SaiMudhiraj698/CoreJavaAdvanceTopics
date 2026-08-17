package ReflectionInJava;

import java.lang.reflect.Field;


public class AccessPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Calculator c=new Calculator();
//        System.out.println(c.a); // we can't access directly so we use reflection concept


               // Reflection


        Class<Calculator> clazz =Calculator.class;   //class reference stores metadata information like class,methods,variables(static,instance)
        Field field=clazz.getDeclaredField("a");
        field.setAccessible(true);  // we saying that we can access the variable from now
        System.out.println(field.getInt(c));

    }
}
