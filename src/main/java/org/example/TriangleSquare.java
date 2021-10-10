package org.example;


public class TriangleSquare {
    public static Double calculate(Double a, Double b, Double c) throws ValueException {
        if (a <= 0 || b <= 0 || c <= 0){
            throw new ValueException("Ожидались положительные значения");
        }

        Double p = (a+b+c)/2;
        Double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        if (Double.isNaN(s)){
            throw new ValueException("Переданные значения не составляют треугольник");
        }
        return s;
    }
}
