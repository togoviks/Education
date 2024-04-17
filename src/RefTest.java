import java.lang.reflect.Method;

public class RefTest {

    public void test() {
        try {
            Class<String> stringClass = String.class;
            Method lenghtMethod = stringClass.getMethod("length");
            String testString = "Test";
            System.out.println(lenghtMethod.invoke(testString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}