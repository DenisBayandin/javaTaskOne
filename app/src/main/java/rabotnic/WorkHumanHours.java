/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabotnic;

/**
 *
 * @author Баян
 */
public class WorkHumanHours extends WorkHuman{
    int workTime;

    public WorkHumanHours() {
        super();
    }
    
    public WorkHumanHours(String name, int age, int pay) {
        super(name, age, pay);
    }

    public WorkHumanHours(String name, int age, int pay, int workTime) {
        super(name, age, pay);
        this.workTime = workTime;
    }
    
    @Override
    public String speak() {
        return "Hello, I work hours time.";
    }

    @Override
    public int getWorkTime() {
        return workTime;
    }

    @Override
    public void setWorkTime(int workHours) {
        this.workTime = workHours;
    }
}
