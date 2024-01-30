package homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Worker {

    public static final int FEMALETEXRATE = 30;
    public static final int MALETEXRATE = 50;


    static int id;
    static String name;
    static String gender;
    static String position;
    static float our;
    static float rate;
    static  int option = 0;

    public  static  void  optionMenu(){
        System.out.println("[1]. Input worker information: ");
        System.out.println("[2]. Show worker information: ");
        System.out.println("[3]. Display salary , rate and deduction:");
        System.out.println("[4]. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       while (true){
           optionMenu();
           option = validation("Enter option menu: ",scanner,"[0-9]+");
           switch (option){
               case 1-> inputWorkerInfor(scanner);
               case 2-> showWorkerInfo();
               case 3-> {
                   System.out.println(salary());
                   fintextdecution();
                   System.out.println("This is total salary: " + totalSalary());

               }
               case 4-> exit(0);
               default -> System.out.println("Invalid option !!");
           }
       }
    }
    public static void inputWorkerInfor(Scanner scanner){

        id = validation("Enter id: ",scanner,"[0-9]+");

        name = validation2("Enter name: ",scanner,"[a-zA-Z]+");

        gender = validation2("Enter gender: ",scanner,"^(male|female|Male|Female|MALE|FEMALE)$");

        position = validation2("Enter position: ",scanner,"[a-zA-Z]+");

        our = validation3("Enter our: ",scanner,"[0-9]+");

        rate = validation3("Enter rate: ",scanner,"[0-9]+");
    }
    public static void showWorkerInfo(){
        System.out.println("Worker id: " + id);
        System.out.println("Worker name: " + name);
        System.out.println("Worker gender: " + gender);
        System.out.println("Worker position: " + position);
        System.out.println("Worker our: " + our);
        System.out.println("Worker rate: " + rate);
    }
    public static float salary(){
        float salary = our * rate;
        return salary;
    }
    public static float totalSalary(){float a = salary()-fintextdecution();
        return a;
    }

    public static int validation(String message,Scanner scanner,String regex){
        while (true){
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            boolean result = matcher.find();
            if (result){
                System.out.println("Successfully validation: !!");
                return Integer.parseInt(number);
            }else {
                System.out.println("Invalid validation !!");
            }
        }
    }
    public static String validation2(String message,Scanner scanner,String regex){
        while (true){
            System.out.println(message);
            String number = scanner.nextLine();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            boolean result = matcher.find();
            if (result){
                System.out.println("Successfully validation: !!");
                return number;
            }else {
                System.out.println("Invalid validation !!");
            }
        }
    }
    public static float validation3(String message,Scanner scanner,String regex){
        while (true){
            System.out.println(message);
            String number = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            boolean result = matcher.find();
            if (result){
                System.out.println("Successfully validation: !!");
                return Float.parseFloat(number);
            }else {
                System.out.println("Invalid validation !!");
            }
        }
    }
    public static float fintextdecution(){
        float rate1;
        if (gender.equalsIgnoreCase("Male")){
            rate1 = MALETEXRATE;
        }else {
            rate1 = FEMALETEXRATE;
        }
        float deduction = 0;
        if (salary() >= 1000){
             deduction= salary() * (rate1/100);
            System.out.println("Tex rate: " + rate1 );
            System.out.println("Tex salary deduction "+ deduction + " $");
        }
        return deduction;
    }
}
