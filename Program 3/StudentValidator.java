public class StudentValidator {
 public static boolean isValidAge(int age) {
     return age >= 18 && age <= 100;
 }

 public static boolean isValidSgpa(double sgpa) {
     return sgpa >= 0 && sgpa <= 10;
 }
}
