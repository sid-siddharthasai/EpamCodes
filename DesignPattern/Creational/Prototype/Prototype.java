package DesignPattern.Creational.Prototype;

import java.util.*;

class Vehicle implements Cloneable{
    private List<String> listOfVehicle;
    
    public Vehicle(){
        this.listOfVehicle = new ArrayList<String>();
    }

    public Vehicle(List<String> list){
        this.listOfVehicle = list;
    }

    public void insertData(){
        listOfVehicle.add("Swift");
        listOfVehicle.add("XUV 700");
        listOfVehicle.add("Audi R8");
        listOfVehicle.add("lamborgini urus");
    }

    public List<String> getVehicleList(){
        return this.listOfVehicle;
    }

    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();

        for(String s: this.getVehicleList()){
            temp.add(s);
        }
        return new Vehicle(temp);
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException{
        Vehicle vehicle = new Vehicle();
        vehicle.insertData();

        Vehicle vehicle2 = (Vehicle) vehicle.clone();
        List<String> list = vehicle2.getVehicleList();
        list.add("Mercedes G-Class");

        System.out.println(vehicle.getVehicleList());
        System.out.println(list);
        list.remove("Swift");
        System.out.println(list);

    }
}
