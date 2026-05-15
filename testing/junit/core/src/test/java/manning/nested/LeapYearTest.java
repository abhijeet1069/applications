package manning.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {

    @Nested
    class A_year_is_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = {2020, 2016, 1984, 4})
        void if_it_is_divisible_by_4_but_not_by_100(int year) {
            assertTrue(LeapYear.isLeap(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {400, 800, 1200, 2000})
        void if_it_is_divisible_by_400(int year) {
            assertTrue(LeapYear.isLeap(year));
        }
    }

    @Nested
    class A_year_is_not_a_leap_year {

        @ParameterizedTest
        @ValueSource(ints = {2022, 2019, 1999, 1})
        void if_it_is_not_divisible_by_4(int year) {
            assertFalse(LeapYear.isLeap(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {2100, 1900, 1700})
        void if_it_is_divisible_by_100_but_not_by_400(int year) {
            assertFalse(LeapYear.isLeap(year));
        }
    }
}