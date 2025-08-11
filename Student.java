class Student {
String name; int age;

Student(String n,int a){
name = n;
age = a;

}
void display(){
System.out.println("Name : "+name+ "\nAge : "+age);

}

public static void main(String[]args){

Student s1=new Student("Yuvan",24);
s1.display();
}
}
