import fr.zenity.appium.utils.ArrayBuilder;
import fr.zenity.appium.utils.Collector;
import fr.zenity.appium.utils.Collectors;
import fr.zenity.appium.utils.Optional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws Exception {

        // Optional with String(primitif) type
        Optional<String> txt = Optional.of("Roose");
        System.out.println(txt.get());
        System.out.println(txt.toString());
        System.out.println(txt.equals(txt));
        System.out.println(txt.equals(null));

        // exemple 2
        Optional<String> txt2 = Optional.ofNullable(null);
        System.out.println(txt2.isPresent());
        System.out.println(txt2.toString());
        System.out.println(txt2.isEmpty());
        System.out.println(txt2.orElse("toto"));
        System.out.println(txt2.orElseGet(() -> "blblblbllbb"));


        Optional.of("1")
                .map(Integer::parseInt)
                .get();

        List<String> list = Arrays.asList("6","0","6","9","300","200");
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            System.out.println("predicate: "+   Optional.of(i.next())
                    .map(Integer::parseInt)
                    .filter((val)-> val < 5)
                    .orElse(100));
        }

       /* System.out.println("predicate: "+   Optional.of("5")
                .map(Integer::parseInt)
                .filter((val)-> val < 5)
                .orElse(100));*/

        Collector<String, List<String>> collector = Collectors.toList();

        ArrayBuilder<String> li = new ArrayBuilder<>();
        List<String> lia = collector.supplier().get();
        li.accept("45");
        li.accept("50");
        li.accept("10");
        li.splitIterator().forEachRemaining((value)->collector.accumulator().accept(lia, value));
        System.out.println("===========================");
        lia.forEach(System.out::println);
       // lia.splitIterator().forEachRemaining(System.out::println);
        //li.get().forEach(System.out::println);
        //txt2.orElseThrow(new RuntimeException("null"));



        // Optional with int (primitif) type
        /*Optional<Integer> number = new Optional<>(15);
        System.out.println(number.get());
        number.setT(87);
        System.out.println(number.get());*/

        // Optional with boolean (primitif) type
        /*Optional<Boolean> number = new Optional<>(true);
        System.out.println(number.get());
        number.setT(false);
        System.out.println(number.get());*/

        Optional.of(null);
    }

}
