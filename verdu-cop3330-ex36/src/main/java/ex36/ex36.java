package ex36;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.Scanner;
import java.util.ArrayList;

public class ex36 {

    public static void main(String[] Args){

          int n = 0;
          int num_numbers = 0;

          Scanner scanner = new Scanner(System.in);
          ArrayList<String> numbers = new ArrayList<String>();

          while (n == 0){

              System.out.print("Enter a number: ");
              String number = scanner.nextLine();

              if (number.equals("done")){
                  num_numbers += 1;
                  n=1;
                  break;
              }
              else if (number.matches("[^0-9]+")){
                 System.out.println("Please enter a valid number.");
                 continue;
              }

              num_numbers += 1;
              numbers.add(number);

          }

          System.out.print("Numbers: ");

          for (int i = 0; i < num_numbers-1; i++) {
              if (i == num_numbers-2){
                 System.out.print(numbers.get(i) + ".");
                }

              else {
                 System.out.print(numbers.get(i) + ", ");
                }
          }



          double average = average(numbers, num_numbers);
          int minimum = min(numbers, num_numbers);
          int maximum = max(numbers, num_numbers);
          double standard_dev = std(numbers, num_numbers, minimum, maximum, average);

          System.out.println("\nThe average is " + String.format("%.1f", average));
          System.out.println("The minimum is " + minimum);
          System.out.println("The minimum is " + maximum);
          System.out.println("The standard deviation is " + String.format("%.2f", standard_dev));





    }

    public static double average (ArrayList<String> numbers, int num_numbers){

       int n = 0;
       double average = 0;

       for (int i = 0; i<num_numbers-1; i++){
           double number = Double.parseDouble(numbers.get(i));
           average += number;
           n += 1;
       }

       average = average/n;

       return average;

    }

    public static int min (ArrayList<String> numbers, int num_numbers){

        int number = Integer.parseInt(numbers.get(0));
        int min = number;

        for (int i = 0; i<num_numbers-1; i++){
            int placeholder = Integer.parseInt(numbers.get(i)) ;

            if (min > placeholder){
                min = placeholder;
            }
        }

        return min;

    }

    public static int max (ArrayList<String> numbers, int num_numbers){

         int max = 0;

         for (int i = 0; i<num_numbers-1; i++){
             int placeholder = Integer.parseInt(numbers.get(i)) ;

             if (max < placeholder){
                max = placeholder;
             }
         }

         return max;

    }

    public static double std (ArrayList<String> numbers, int num_numbers, int min, int max, double average){

        int n = 0;
        double std = 0;

        for (int i = 0; i<num_numbers-1; i++) {
            int placeholder = Integer.parseInt(numbers.get(i));
            std += Math.pow((placeholder-average), 2);
            n += 1;
        }

        std = std/n;
        std = Math.sqrt(std);

        return std;

    }



}
