// К калькулятору из предыдущего дз добавить логирование.

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args){
        System.out.println("Hi! Let's calculate!");
        double x = getNumber();
        double y = getNumber();
        char operation = getOperation();
        double result = calc(x, y, operation);
        System.out.println(result);
        
    }
    
    public static double getNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer:");
        double num;
        if(sc.hasNextDouble()){
            num = sc.nextDouble();
            logger("Entered number " + num);
        } else {
            logger("Error: wrong number entered");
            System.out.println("Error! Try again!");
            sc.next();
            num = getNumber();
        }
        sc.close();
        return num;
    }
    public static char getOperation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operation (+, -, *, /): ");
        char operation;
        if(sc.hasNext()){
            operation = sc.next().charAt(0);
            logger("Entered operation: " + operation);
        } else {
            logger("Error: wrong operation symbol entered");
            System.out.println("Error! Try again!");
            sc.next();
            operation = getOperation();
        }
        sc.close();
        return operation;
        
    }
 
    public static double calc(double x, double y, char operation){
        double result;
        switch (operation){
            case '+':
                result = x + y;
                logger("The sum equals " + result);
                break;
            case '-':
                result = x - y;
                logger("The difference equals " + result);
                break;
            case '*':
                result = x * y;
                logger("The multiplication equals " + result);
                break;
            case '/':
                result = x / y;
                logger("The division equals " + result);
                break;
            default:
                logger("Error: wrong operation character");
                System.out.println("Oops! Wrong operation character! Please, try again!");
                result = calc(x, y, getOperation());
        }
        return result;
    }

    public static void logger(String text){
        try{
            FileWriter log = new FileWriter("log.txt", true);
            log.write(LocalDateTime.now() + " " + text + "\n");
            log.flush();
            log.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}


