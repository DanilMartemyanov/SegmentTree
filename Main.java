package org.example;


import java.time.Instant;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long allelapsed = 0 ;
        int[] numbers = new int[10000];
        SegmentTree tree = new SegmentTree(numbers);
        for(int i  =  0 ; i < numbers.length ; i ++){
            long start1 = System.nanoTime();
            numbers[i] = (int) (Math.random()*10);
            tree.update(i , numbers[i]);
            long finish1 = System.nanoTime();
            long elapsed = finish1 - start1;
             allelapsed = elapsed + allelapsed;
        }
        System.out.println("Добавление элемента в структуру " + allelapsed);
        System.out.println("------------------------------------------------------");
        System.out.println(Arrays.toString(numbers));

        long start2 = System.nanoTime();
        int summy  = tree.sum(2, 5);
        long finish2 = System.nanoTime();
        long elapsed2 = finish2 - start2;
        System.out.println("Сумма " + summy);
        System.out.println("Прошло времени (сумма элементов), нс: " + elapsed2);
        System.out.println("------------------------------------------------------");
        System.out.println("Среднее значение (добавление , сумма) " + (allelapsed+summy)/2);
    }
}