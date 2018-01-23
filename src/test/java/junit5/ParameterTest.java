package junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterTest {

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        assertTrue(isPalindrome(candidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {"foo", "bar"})
    void noPalindromes(String candidate) {
        assertFalse(isPalindrome(candidate));
    }

    private boolean isPalindrome(String foo) {
        return new StringBuilder(foo).reverse().toString().equals(foo);
    }
}
