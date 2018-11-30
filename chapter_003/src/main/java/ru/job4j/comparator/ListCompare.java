package ru.job4j.comparator;

import java.util.Comparator;

public class ListComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int l = left.length() > right.length() ? left.length() : right.length();
        int i = 0;
        for (int k = 0; k < l; k++) {
            if (!(left.charAt(k) / right.charAt(k) == 0)) {
                i = left.charAt(k) > right.charAt(k) ? 1 : -1;
                break;
            }
        }
        if (i == 0 && !(left.length() == right.length())) {
            i = left.length() > right.length() ? 1 : -1;
        }
        return i;
    }
}
