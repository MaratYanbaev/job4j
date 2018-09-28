package ru.job4j.loop;

//Собственная реализация построения пирамиды.

public class MyOwnPaint {
    public String myOwnPyramid(int h) {

        StringBuilder view = new StringBuilder();
        int a = h + h - 1; // Ширина пирамиды.
        int b = h - 1; // Расстояние от края до центра.
        int width = a;

        for (int row = 0; row != h; row++) {
            for (int i = a; i != -2; i--) {
                for (int d = 0; d != b; d++) {
                    i--;
                    width--;
                    view.append(" ");
                }
                if (b + width == a) {
                    for (int c = b + b - a; c != 0; c++) {
                        i--;
                        width--;
                        view.append("^");
                        if (b == 0 & i == 0) {
                            i--;
                        }
                    }
                }
                if (width == 0) {
                    if (b != 0) {
                        b--;
                    }
                    width = a;
                }
            }
            view.append(System.lineSeparator());
        }
        return view.toString();
    }
}