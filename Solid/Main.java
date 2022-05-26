package Solid;
import java.util.*;

//Single Responsibility Principle

class User{
    UserLogin userLogin = new UserLogin();
    UserRegister userRegister = new UserRegister();
    RegistrationCheck regCheck = new RegistrationCheck();
    Scanner scan = new Scanner(System.in);
    String ans;

    public void greetUser(){
        System.out.println("Welcome to Swiggy!!!!");
        System.out.println("If you are a registered user enter 'yes' else 'no' -");
        ans = scan.nextLine();

        if(regCheck.checkRegistered(ans) == true)
        userLogin.login();
        else
        userRegister.register();
    }


}

class RegistrationCheck{
    boolean registered = false;
    public boolean checkRegistered(String answer){
        if(answer.equals("yes"))
        registered = true;
        
        return registered;
    }
}

class UserLogin{
    public void login(){
        System.out.println("Enter email and password:");
        System.out.println("You are successfully logged in");
    }
}

class UserRegister{
    public void register(){
        System.out.println("Register yourself by entering details.");
        System.out.println("Registration Successful");;
    }
}

//Open-Closed Principle

interface Payment{
    void makePayment();
}

class DebitCard implements Payment{

    @Override
    public void makePayment() {
     System.out.println("Enter debit card details:");
     System.out.println("Payment Successful");   
    }
    
}

class CreditCard implements Payment{

    @Override
    public void makePayment() {
        System.out.println("Enter credit card details:");
        System.out.println("Payment Successful");
    }
}

//Liskov substitution principle

abstract class NonVeg{
    abstract void starter();
    abstract void mainCourse();
}

class Chicken extends NonVeg{

    @Override
    void starter() {
        System.out.println("Starter");
        System.out.println("Chicken Sekh Kebab");
    }

    @Override
    void mainCourse() {
        System.out.println("Main Course");
        System.out.println("Chicken Biryani");
    }

}

class Mutton extends NonVeg{
    
    @Override
    void starter() {
        System.out.println("Starter");
        System.out.println("Mutton Sekh Kebab");
    }

    @Override
    void mainCourse() {
        System.out.println("Main Course");
        System.out.println("Mutton Biryani");
    }
}

//Interface Segregation Principle

interface IndianDesserts{
    void getIndian();
}

interface ForeignDesserts{
    void getForeign();
}

class IndianSweets implements IndianDesserts{

    @Override
    public void getIndian() {
       System.out.println("Indian Desserts:");
       System.out.println("Gulab Jamun");
       System.out.println("Rasgulla");
    }

}

class ForeignSweetDish implements ForeignDesserts{

    @Override
    public void getForeign() {
       System.out.println("Foreign Desserts:");
       System.out.println("Donuts");
       System.out.println("Milkshake");
    }

}

//Dependency Inversion

interface Rating{
    void giveRating(int rating);
}

class DeliveryAgentRating implements Rating{
    String entity = "Delivery Agent";
    @Override
    public void giveRating(int rating) {
        System.out.println("You have rated " + rating+"/5 for the delivery agent.");
    }

}

class DishRating implements Rating{
    String entity = "Dish";
    @Override
    public void giveRating(int rating) {
        System.out.println("You have rated "+ rating+"/5 for the dish.");  
    }

}

class RatingHandler{
    Rating rate;
    public RatingHandler(Rating rate){
        this.rate = rate;
    }
    public void entityRating(int rating){
        rate.giveRating(rating);
    }
}

class Main{
    static void chooseDish(NonVeg nonVeg){
        nonVeg.starter();
        nonVeg.mainCourse();
    }
    public static void main(String[] args) {
        User user = new User();
        user.greetUser();
        System.out.println();

        chooseDish(new Chicken());
        System.out.println();
        chooseDish(new Mutton());
        System.out.println();

        IndianDesserts indian = new IndianSweets();
        indian.getIndian();
        System.out.println();
        ForeignDesserts foreign = new ForeignSweetDish();
        foreign.getForeign();
        System.out.println();

        Payment pay = new DebitCard();
        pay.makePayment();
        System.out.println();

        pay = new CreditCard();
        pay.makePayment();
        System.out.println();

        Rating rate = new DeliveryAgentRating();
        RatingHandler ratingHandler = new RatingHandler(rate);
        ratingHandler.entityRating(5);
        System.out.println();

        rate=new DishRating();
        ratingHandler = new RatingHandler(rate);
        ratingHandler.entityRating(5);
}
}