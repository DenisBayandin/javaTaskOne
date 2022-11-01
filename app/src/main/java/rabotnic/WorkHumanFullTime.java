/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabotnic;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Баян
 */
public class WorkHumanFullTime extends WorkHuman{
    int workTime;
    public WorkHumanFullTime() {
        super();
    }
    
    public WorkHumanFullTime(String name, int age, int pay){
        super(name, age, pay);
        setChanged();
        notifyObservers();
    }
    
    public WorkHumanFullTime(String name, int age, int pay, int workTime){
        super(name, age, pay);
        this.workTime = workTime;
        setChanged();
        notifyObservers();
    }
    
    @Override
    public String speak() {
        return "Hello, I work full time.";
    }

    @Override
    public int getWorkTime() {
        return this.workTime;
    }
    
    @Override
    public void setWorkTime(int daysCount) {
        this.workTime = daysCount;
        setChanged();
        notifyObservers();
    }
}
