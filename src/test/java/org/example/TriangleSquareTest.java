package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleSquareTest {

    @Test
    void testCorrectSquare() throws ValueException {
        Double s = TriangleSquare.calculate(3.0,4.0,5.0);
        Assertions.assertEquals(6.0,s,"Площади не равны");
    }

    @ParameterizedTest
    @CsvSource({
            "-3.0,4.0,5.0",
            "3.0,-4.0,5.0",
            "3.0,4.0,-5.0",
            "0.0,4.0,5.0",
            "3.0,0.0,5.0",
            "3.0,4.0,0.0",
    })
    void testNegativeValues(Double a, Double b, Double c){
        ValueException ex = Assertions.assertThrows(ValueException.class, ()->TriangleSquare.calculate(a, b, c));

        Assertions.assertEquals("Ожидались положительные значения", ex.getMsg());
    }

    @Test
    void testAbnormalValues() throws ValueException {
        ValueException ex = Assertions.assertThrows(ValueException.class, ()->TriangleSquare.calculate(7.0,1.0,35.0));
        Assertions.assertEquals("Переданные значения не составляют треугольник", ex.getMsg());
    }

}
