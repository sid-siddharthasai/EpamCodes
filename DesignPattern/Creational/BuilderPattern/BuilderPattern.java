package DesignPattern.Creational.BuilderPattern;

class Computer{
    private String processor;
    private int ram;
    private int ssd;
    private int hdd;
    private String graphicsCard;
    private int monitorSize;

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }
    public int getSsd() {
        return ssd;
    }

    public int getHdd() {
        return hdd;
    }
    public String getGraphicsCard() {
        return graphicsCard;
    }

    public int getMonitorSize() {
        return monitorSize;
    }

    public String toString(){
        return "Choosen configuration is- \nProcessor: "+processor+"\nRAM: "+ram
        +"GB \nSSD: "+ssd+"GB \nHDD: "+hdd+"GB \nGraphics Card: "+graphicsCard+"\nMonitor Size: "+monitorSize+" inch";
    }

    private Computer(ComputerBuilder computerBuilder){
        this.processor = computerBuilder.processor;
        this.ram = computerBuilder.ram;
        this.ssd = computerBuilder.ssd;
        this.hdd = computerBuilder.hdd;
        this.graphicsCard = computerBuilder.graphicsCard;
        this.monitorSize = computerBuilder.monitorSize;
    }


    public static class ComputerBuilder{
        private String processor;
        private int ram;
        private int ssd;
        private int hdd;
        private String graphicsCard;
        private int monitorSize;

    public ComputerBuilder setProcessor(String processor){
        this.processor = processor;
        return this;
    }
    public ComputerBuilder setRam(int ram){
        this.ram = ram;
        return this;
    }
    public ComputerBuilder setSsd(int ssd){
        this.ssd = ssd;
        return this;
    }
    public ComputerBuilder setHdd(int hdd){
        this.hdd = hdd;
        return this;
    }
    public ComputerBuilder setMoniterSize(int monitorSize){
        this.monitorSize = monitorSize;
        return this;
    }
    public ComputerBuilder setGraphicsCard(String graphicsCard){
        this.graphicsCard = graphicsCard;
        return this;
    }

    public Computer build(){
        return new Computer(this);
    }
} 
}


public class BuilderPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
        .setProcessor("Ryzen 9 5950x")
        .setRam(32)
        .setSsd(1024)
        .setGraphicsCard("RTX 3080Ti")
        .setMoniterSize(24)
        .build();
        System.out.println(computer);
    }
}
