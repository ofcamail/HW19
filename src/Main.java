import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main  {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        System.out.println(isPositive.test(-1));

        Predicate<Integer> isPos = x -> x >= 0;
        System.out.println(isPos.test(1));
    }

    private static void task2() {
        Consumer <String> sayHello = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Здравия желаю, " + s);
            }
        };
        sayHello.accept("Кротов Крот Кротович");

        Consumer <String> sayOla = s -> System.out.println("Здравия желаю, " + s);
        sayOla.accept("Годзила Годзиловна");
    }

    private static void task3() {
        Function <Double, Long> round = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(round.apply(3.76));

        Function <Double, Long> round2 = Double::longValue;
        System.out.println(round2.apply(2.876));
    }

    private static void task4() {
        Random randomNumber = new Random();
        Supplier <Integer> randomaze = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return randomNumber.nextInt(100);
            }
        };
        System.out.println(randomaze.get());
        Supplier <Integer> randomaze2 = () -> randomNumber.nextInt(100);
        System.out.println(randomaze2.get());
    }


    private static void task5() {
        Scanner yearScanner = new Scanner(System.in);
        System.out.println("Enter the year");
        int yearForCheck = yearScanner.nextInt();
        boolean isLeapYear = ((yearForCheck % 4 == 0) && (yearForCheck % 100 != 0) || (yearForCheck % 400 == 0));
        Predicate<Boolean> isLeap = x -> isLeapYear;
        Function<Boolean, String> leap = x -> isLeapYear + " високосный год";
        Function<Boolean, String> noLeap = x -> isLeapYear + " не високосный год";
        System.out.println(ternaryOperator(isLeap, leap, noLeap).apply(isLeapYear));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        Function<T, U> newFunction = t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
        return newFunction;
    }
}