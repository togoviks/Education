import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public void printColumn(int col) {
        IntStream.rangeClosed(1, 9)
                .mapToObj(num -> String.format("%d * %d = %d", num, col, num * col))
                .forEach(System.out::println);
    }

    public void printMultTable() {
        IntStream.rangeClosed(1, 9)
                .forEach(this::printColumn);
    }

    public void numbers() {
        IntStream.iterate(1, i -> i < 1000, i -> i * 2)
                .forEach(System.out::println);
    }

    public void arrayThree() {
        int[] array = IntStream.generate(() -> 3)
                .limit(10)
                .toArray();
    }

    public List<String> sortList(List<String> list) {
        return list.stream()
                .filter(s -> s.length() < 3)
                .toList();
    }

//    public List<Person> listOfNames(List<String> names) {
//        return names.stream()
//                .map(Person::new)
//                .toList();
//    }

    public void listToString(List<String> list) {
        String a = list.stream()
                .collect(Collectors.joining());
        System.out.println(a);
    }

    public void friday13() {
        LocalDate day13 = LocalDate.now().withDayOfMonth(13);

        Stream.iterate(day13, date -> date.plusMonths(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .limit(5)
                .map(n -> n.getYear() + " " + n.getMonth())
                .forEach(System.out::println);
    }

    public List<LocalDate> findDate(String text) {
        return Pattern.compile("\\d{4}-\\d{2}-\\d{2}").matcher(text).results()
                .map(MatchResult::group)
                .map(LocalDate::parse)
                .toList();
    }

    public BigInteger bigNumber(String number) {
        return Arrays.stream(number.split("\\+"))
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO ,BigInteger::add);
    }

    public void personProducts(List<Person> personList) {
        personList.stream()
                .map(Person::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    public void printWord(String words) {
        String a = Arrays.stream(words.split(","))
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
        System.out.println(a);
    }
}