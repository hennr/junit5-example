package junit5;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class FactoryTest {

    private List<String> input = new ArrayList<>();
    private List<String> expected = new ArrayList<>();

    @TestFactory
    Stream<DynamicTest> translateDynamicTestsFromStream() {

        input.add("foo");
        input.add("bla");
        expected.add("bar");
        expected.add("baz");

        return input.stream().map(word ->
                dynamicTest("Test mapper for " + word, () -> {
                    int index = input.indexOf(word);
                    assertEquals(expected.get(index), translate(word));
                })
        );
    }

    private String translate(String word) {
        if (word.equals("foo")) {
            return "bar";
        }
        else {
            return "baz";
        }
    }
}
