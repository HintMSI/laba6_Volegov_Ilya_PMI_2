import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        // Создаем экземпляр класса MyClass
        MyClass myClass = new MyClass();

        // 1. Работа с аннотацией @Invoke
        Method method = myClass.getClass().getMethod("myMethod");
        if (method.isAnnotationPresent(Invoke.class)) {
            method.invoke(myClass);  // Вызов метода через рефлексию
        }
        System.out.println(" ");

        // 2. Работа с аннотацией @Default
        Default defaultAnnotation = MyClass.class.getAnnotation(Default.class);
        if (defaultAnnotation != null) {
            System.out.println("Class works with: " + defaultAnnotation.value().getName());
        }
        System.out.println(" ");

        // 3. Работа с аннотацией @ToString
        ToString toStringAnnotation = MyClass.class.getAnnotation(ToString.class);
        if (toStringAnnotation != null && "YES".equals(toStringAnnotation.value())) {
            System.out.println(myClass.toString());  // Вывод: Custom string representation of MyClass
        }
        System.out.println(" ");

        // 4. Работа с аннотацией @Validate
        Validate validateAnnotation = MyClass.class.getAnnotation(Validate.class);
        if (validateAnnotation != null) {
            for (Class<?> clazz : validateAnnotation.value()) {
                System.out.println("Validating: " + clazz.getName());
            }
        }
        System.out.println(" ");

        // 5. Работа с аннотацией @Two
        Two twoAnnotation = MyClass.class.getAnnotation(Two.class);
        if (twoAnnotation != null) {
            System.out.println("First: " + twoAnnotation.first());
            System.out.println("Second: " + twoAnnotation.second());
        }
        System.out.println(" ");

        // 6. Работа с аннотацией @Cache
        Cache cacheAnnotation = MyClass.class.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            for (String data : cacheAnnotation.value()) {
                System.out.println("Cache data: " + data);
            }
        }
        System.out.println(" ");
    }
}