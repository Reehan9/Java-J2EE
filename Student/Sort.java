import java.util.*;
public class Sort implements Comparator<Student> {
 public int compare(Student s1 , Student s2){
    return s1.name.compareTo(s2.name);
}

}