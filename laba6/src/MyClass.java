@Default(value = String.class)  // Применение аннотации @Default
@ToString(value = "YES")        // Применение аннотации @ToString
@Validate(value = {String.class, Integer.class})  // Применение аннотации @Validate
@Two(first = "Example", second = 123)  // Применение аннотации @Two
@Cache(value = {"data1", "data2"})  // Применение аннотации @Cache
public class MyClass {

    @Invoke  // Применение аннотации @Invoke
    public void myMethod() {
        System.out.println("Method is invoked!");
    }

    @Override
    public String toString() {
        return "MyClass instance";
    }
}