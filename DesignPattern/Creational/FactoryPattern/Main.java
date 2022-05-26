package DesignPattern.Creational.FactoryPattern;

import java.util.Scanner;

interface Category{
    void getCategoryCount();
}

class Grocery implements Category{

    @Override
    public void getCategoryCount() {
       System.out.println("You have choosen Grocery");
       System.out.println("Stock: 250 units");
        
    }

}

class Mobiles implements Category{

    @Override
    public void getCategoryCount() {
       System.out.println("You have choosen Mobiles");
       System.out.println("Stock: 150 units");
        
    }

}

class Clothes implements Category{

    @Override
    public void getCategoryCount() {
       System.out.println("You have choosen Colthes");
       System.out.println("Stock: 1500 units"); 
    }

}

class CategoryFactory{
    public Category getCategory(String categoryName){
        if(categoryName.equalsIgnoreCase("Grocery"))
        return new Grocery();
        else if(categoryName.equalsIgnoreCase("Mobiles"))
        return new Mobiles();
        else
        return new Clothes();
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Welcome to Amazon inventory!!!!");
        System.out.println();
        System.out.println("Enter the name of the Category:");
        input = scan.nextLine();
        scan.close();
        System.out.println();
        CategoryFactory categoryFactory = new CategoryFactory();
        Category selectedCategory = categoryFactory.getCategory(input);
        selectedCategory.getCategoryCount();

    }
}
