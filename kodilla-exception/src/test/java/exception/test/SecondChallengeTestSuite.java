package exception.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowExceptionWhenNotThrowing() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1));
    }

    @Test
    void testProbablyIWillThrowExceptionWhenThrowing() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1));
    }

    @Test
    void testProbablyIWillThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1.3)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5))
        );
    }
}
