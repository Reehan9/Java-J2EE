import java.util.*;
class Thread1 extends Thread{
    Scanner sc= new Scanner(System.in);
   String[] digits={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public void run()
    {
        try{
        	System.out.println("Enter the four digit number");
       int number = sc.nextInt();
        
        if(number> 9999 || number<1000){
            throw new Exception();
        }
        
        else{
            while(number!=0)
            {
                int value= number%10;
                System.out.println(digits[value]);
                number/=10;
            }
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

class Thread2 extends Thread{
    Scanner sc= new Scanner(System.in);
    public void run()
    {               
        System.out.println("Enter the vowels");
    	String input=sc.nextLine();
        
        int vowel= 0;
        for(int i =0; i< input.length(); i++)
        {
         char target= input.charAt(i);
  if(target=='A'||target=='a'||target=='e'||target=='E'||target=='i'||target=='I'||target=='o'||target=='O'||target=='U'||target=='u') {
                vowel++;
        }
        
    }
        System.out.println(vowel);
}
}

public class Main {
    public static void main(String[] args)
    {
        Thread1 th1= new Thread1();
        Thread2 th2= new Thread2();
      
        th1.run();  
        th2.run();
        
    }
}