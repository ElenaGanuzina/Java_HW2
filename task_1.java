// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class task_1{
    public static void main(String[] args){
        int[]arr = getArray(getArrayLength());
        printArray(arr);
        printArray(bubbleSort(arr));

    }
    public static int getArrayLength(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array's length: ");
        int number;
        if (sc.hasNextInt()){
            number = sc.nextInt();
            logger("The array's length was entered: " + number);
        }
        else 
        {
            logger("An incorrect array's length was entered.");
            System.out.println("Error! Please, try again!");
            sc.next();
            number = getArrayLength();
        }
        sc.close();
        return number;
    }
    
    public static int[] getArray(int number){
        int[] array =  new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(0, 100);
        }
        logger("The following array was created: " + Arrays.toString(array));
        return array;
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }

    public static int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array [j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger("Swap " + array[j] + " and " + array[j+1]);
                }
            }
        }
        return array;
    }

    public static void logger(String text){
        try{
            FileWriter log = new FileWriter("log1.txt", true);
            log.write(LocalDateTime.now() + " " + text + "\n");
            log.flush();
            log.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

}