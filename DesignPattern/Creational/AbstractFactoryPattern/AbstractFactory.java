package DesignPattern.Creational.AbstractFactoryPattern;

interface Laptops{
    void assemble();
}

interface PreBuiltPc{
    void assemble();
}

class HpLaptops implements Laptops{

    @Override
    public void assemble() {
        System.out.println("HP: Building laptops");
    }

}

class HpPreBuiltPc implements PreBuiltPc{

    @Override
    public void assemble() {
        System.out.println("HP: Building PCs");
    }

}

class DellLaptops implements Laptops{

    @Override
    public void assemble() {
        System.out.println("Dell: Building Laptops");
    }

}

class DellPreBuiltPc implements PreBuiltPc{

    @Override
    public void assemble() {
        System.out.println("Dell: Building PCs");
    }

}

abstract class Company{
    abstract PreBuiltPc createPc();
    abstract Laptops createLaptop();
}

class HpManufacturer extends Company{

    @Override
    PreBuiltPc createPc() {
        return new HpPreBuiltPc();
    }

    @Override
    Laptops createLaptop() {
        return new HpLaptops();
        
    }

}

class DellManufactutrer extends Company{

    @Override
    PreBuiltPc createPc() {
        return new DellPreBuiltPc();
    }

    @Override
    Laptops createLaptop() {
        return new DellLaptops();
    }

}

public class AbstractFactory {
    public static void main(String[] args) {
        Company hp = new HpManufacturer();
        Laptops laptops = hp.createLaptop();
        laptops.assemble();
        PreBuiltPc pc = hp.createPc();
        pc.assemble();
        System.out.println();

        Company dell = new DellManufactutrer();
        laptops = dell.createLaptop();
        laptops.assemble();
        pc = dell.createPc();
        pc.assemble();
    }
}
