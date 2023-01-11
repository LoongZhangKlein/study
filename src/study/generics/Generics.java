package study.generics;


import javax.swing.*;
import java.util.Arrays;

/**
 * @author jiava
 * @Description DOING
 * @date 2022-12-01-14:51
 */
public class Generics {
    public  static <E> void printArrays(E[] arrays){
        Arrays.stream(arrays).forEach(res-> System.out.println(res));
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,2,3,4,5,};

        String[] string = new String[10];
        for (int i = 0; i < string.length; i++) {
            string[i]= "String";
        }
        printArrays(integers);
        printArrays(string);
    }
}
