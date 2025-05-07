package DEMO;

//S - Single Responsibility Principle
class Student {
 String name;

 Student(String name) {
     this.name = name;
 }

 String getInfo() {
     return "Name: " + name;
 }
}

//O - Open/Closed Principle
class Greeting {
 String sayHello(String name) {
     return "Hello " + name;
 }
}

class ExcitedGreeting extends Greeting {
 String sayHello(String name) {
     return "Hello " + name + "!!!";
 }
}

//L - Liskov Substitution Principle
class Animal {
 void makeSound() {
     System.out.println("Some sound");
 }
}

class Dog extends Animal {
 void makeSound() {
     System.out.println("Bark");
 }
}

//I - Interface Segregation Principle
interface Playable {
 void play();
}

interface Studyable {
 void study();
}

class Kid implements Playable, Studyable {
 public void play() {
     System.out.println("Kid is playing");
 }

 public void study() {
     System.out.println("Kid is studying");
 }
}

//D - Dependency Inversion Principle
interface MessageSender {
 void send(String msg);
}

class EmailSender implements MessageSender {
 public void send(String msg) {
     System.out.println("Email sent: " + msg);
 }
}

class NotificationService {
 MessageSender sender;

 NotificationService(MessageSender sender) {
     this.sender = sender;
 }

 void notifyUser(String msg) {
     sender.send(msg);
 }
}

public class SOLID{
 public static void main(String[] args) {
     // S
     Student s = new Student("ANANYA");
     System.out.println(s.getInfo());

     // O
     Greeting g = new ExcitedGreeting();
     System.out.println(g.sayHello("ANANYA"));

     // L
     Animal a = new Dog();
     a.makeSound();

     // I
     Kid k = new Kid();
     k.play();
     k.study();

     // D
     NotificationService service = new NotificationService(new EmailSender());
     service.notifyUser("You have a new message.");
 }
}

