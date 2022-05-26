package DesignPattern.Creational.Singleton;

class Singleton{
    String data;
    private static Singleton instance;
    private Singleton(String data){
        this.data = data;
    }

    public static Singleton getInstance(String data){
        if(instance == null){
            instance = new Singleton(data);
        }

        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("Hi");
        Singleton singleton2 = Singleton.getInstance("Hello");
        System.out.println(singleton.data);
        System.out.println(singleton2.data);
    }
}
