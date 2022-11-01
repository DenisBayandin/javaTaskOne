/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabotnic;

import java.util.Observable;

/**
 *
 * @author Баян
 */
abstract class WorkHuman extends Observable{
    String name;
    int age;
    int pay;

    public WorkHuman() {
    }
    
    public WorkHuman(String name, int age) {
        this.name = name;
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public WorkHuman(String name, int age, int pay) {
        this.name = name;
        this.age = age;
        this.pay = pay;
        setChanged();
        notifyObservers();
    }
    
    public int getPay(){
        return pay;
    }
    
    public void setPay(int pay) {
        this.pay = pay;
        setChanged();
        notifyObservers();
    } 

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }
    
    @Override
    public String toString() {
        return "WorkHuman{" + "name=" + this.name + ", age=" + age + ", pay=" + pay + '}';
    }
    
    abstract String speak();

    public void setWorkTime(int workTime){};
    public int getWorkTime(){return 0;};

}
