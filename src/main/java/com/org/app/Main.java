package com.org.app;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");
    }

    public static boolean isOdd(int n) {
       return n % 2 == 0;
    }

    public static int sum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            String num = str.substring(i, i + 1);
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static String toUpperCase(String str) {
        return str != null ? str.toUpperCase() : null;
    }

    public static int lengthOf(String str) {
        return str.length();
    }

    public enum Season {
        WINTER(12,1,2,3), SPRING(4,5,6), AUTUMN(10,11), SUMMER(7,8,9);
        private List<Integer> months;
        Season(Integer... months) {
            this.months = Arrays.asList(months);
        }

        public boolean contains(int i) {
            return months.contains(i);
        }
    }

    public static Season getSeason(Month month) {
        if (month == null) {
            return null;
        }
        int value = month.getValue();
        if (Season.WINTER.contains(value)) {
            return Season.WINTER;
        } else if (Season.SPRING.contains(value)) {
            return Season.SPRING;
        } else if (Season.AUTUMN.contains(value)) {
            return Season.AUTUMN;
        } else if (Season.SUMMER.contains(value)) {
            return Season.SUMMER;
        }
        return null;
    }

}
