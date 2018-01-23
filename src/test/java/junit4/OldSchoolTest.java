package junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// JUnit 4 test classes need to be public; this is not needed for JUnit 5 test classes
public class OldSchoolTest {

    @Test
    public void oldSchoolForLife() {
        assertEquals(1,1);
    }
}
