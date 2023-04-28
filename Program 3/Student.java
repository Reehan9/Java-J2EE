public class Student {
 private String name;
 private String usn;
 private int age;
 private String address;
 private double[] sgpa;
 private String category;

 public Student(String name, String usn, int age, String address, double[] sgpa, String category) {
     this.name = name;
     this.usn = usn;
     this.age = age;
     this.address = address;
     this.sgpa = sgpa;
     this.category = category;
 }

 @Override
 public String toString() {
     return "Name: " + name + ", USN: " + usn + ", Age: " + age + ", Address: " + address + ", Category: " + category;
 }
}
