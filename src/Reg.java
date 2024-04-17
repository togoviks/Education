import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
    String text = "anfa01.05.2012aflm16.12.1245ssi34n2k093.23.da31.11.2011sdgom01.12.12222.sgk.01.01.01.2020.2020.sdgisoj37.05.2052";
    String regex = "(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.\\d{4}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    void test() {
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
