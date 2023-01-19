package com.org.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    /*If you have a single method parameter in the test method and you may represent
    the source of the parameter from one of these built-in types (String, int, long, double), @ValueSource suits.*/
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 15})
    public void checkIfOdd(int number) {
        boolean result = Main.isOdd(number);
        assertEquals(number %  2 == 0, result);
    }

    /*If you have multiple method parameters in the test method, a @CsvSource may suit.
    To use it, annotate the test with @CsvSource and specify in a array of String each case.
    Values of each case are separated by a comma.*/
    @ParameterizedTest
    @CsvSource({ "123, 6", "456, 15", "789, 24" })
    public void checkSum(String strNumber, int expected) {
        int sum = Main.sum(strNumber);
        assertEquals(expected, sum);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"AbC", "abc", "ala ma Kota2", "qeewretrey"})
    public void checkIfUpperCase(String str) {
        String result = Main.toUpperCase(str);
        assertEquals(str != null ? str.toUpperCase() : null, result);
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void checkLength(String str, int length) {
        int result = Main.lengthOf(str);
        assertEquals(length, result);
    }

    public static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of("te", 2),
                Arguments.of("autko", 5),
                Arguments.of("", 0)
        );
    }


    @ParameterizedTest
    @MethodSource("getData2")
    public void checkWhatSeason(Month month, Main.Season season) {
        Main.Season result = Main.getSeason(month);
        assertEquals(season, result);
    }

    public static Stream<Arguments> getData2() {
        return Stream.of(
                Arguments.of(Month.APRIL, Main.Season.SPRING),
                Arguments.of(Month.DECEMBER, Main.Season.WINTER),
                Arguments.of(Month.JUNE, Main.Season.SPRING)
        );
    }
}
