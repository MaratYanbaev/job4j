package ru.job4j.condition;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула
     *
     * (ab + ac + bc)/2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Полупериметр треугольника.
     */

    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }


    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть площадь, если треугольник существует или -1, если треугольника нет.
     */

    public double area() {
        double rsl = -1; // -1 если треугольник нет.
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc, p)) {
            rsl = Math.sqrt(((p - ab) * (p - ac) * (p - bc)) * p);
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @param p Полупериметр треугольника.
     * @return правду или ложь
     */
    private boolean exist(double ab, double ac, double bc, double p) {
        return ((ab + ac != bc) & (ab + bc != ac) & (ac + bc != ab) & (p > ab) & (p > ac) & (p > bc));
    }
}