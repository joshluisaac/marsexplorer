package com.uss.mars.exploration;

public class Command {

    public final String name;
    private int xAxis;
    private int yAxis;

    public Command(String name){
        this.name = name;
    }
    public Command(String name, int xAxis, int yAxis){
        this.name = name;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public String getName() {
        return name;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}
