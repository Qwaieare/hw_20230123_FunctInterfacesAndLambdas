
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача №1");
        Predicate<Integer> positive = new Predicate<>() {
            @Override
            public boolean test(Integer positive) {
                return positive >= 0;
            }
        };
        System.out.println(positive.test(2));
        System.out.println(positive.test(-1));
        System.out.println(positive.test(0));

        System.out.println();

        Predicate<Integer> positive1 = i -> i >= 0;
        System.out.println(positive1.test(2));
        System.out.println(positive1.test(-1));
        System.out.println(positive1.test(0));

        System.out.println();
        System.out.println("Задача №2");

        String name = "Misha";
        Consumer<String> greeting = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello " + name + "!!!");
            }
        };
        greeting.accept(name);

        System.out.println();

        Consumer<String> greeting1 = x -> System.out.println("Hello " + x + "!!!");
        greeting1.accept("Misha");

        System.out.println();
        System.out.println("Задача №3");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double t) {
                return Math.round(t);
            }
        };
        System.out.println(function.apply(2.6));

        System.out.println();

        Function<Double, Long> function1 = n -> Math.round(n);
        System.out.println(function1.apply(2.6));

        System.out.println();
        System.out.println("Задача №4");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier.get());

        System.out.println();

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println(supplier1.get());

        System.out.println();
        System.out.println("Задача №5");

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safe = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safe);


    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }

}