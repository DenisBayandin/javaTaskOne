/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabotnic;

import java.util.ArrayList;

/**
 *
 * @author Баян
 */
public class Department {
    ArrayList<WorkHuman> dep;
    
    public Department(){
        dep = new ArrayList<>();
    }
    
    public void addWorker(WorkHuman human) {
        dep.add(human);
    }
    
    public ArrayList<String> speak(){
        ArrayList<String> speeches = new ArrayList<>();
        for(WorkHuman human:dep) speeches.add(human.speak());
        return speeches;
    }
    
    public void debugSpeeches(){
        for(WorkHuman human:dep){
            System.out.println(human.speak());
        }
    }
    
    public String speak_for(int workHumanNumber){
        return dep.get(workHumanNumber).speak();
    }
    
    public String informationHuman(int workHumanNumber){
        int salaryHuman = 0;
        salaryHuman = dep.get(workHumanNumber).pay * dep.get(workHumanNumber).getWorkTime();
        return "Name = "+ dep.get(workHumanNumber).getName() + 
                ", pay = " + dep.get(workHumanNumber).getPay() + 
                ", work time = " + dep.get(workHumanNumber).getWorkTime() + 
                ", salary = " + salaryHuman;
        
    }
    
    public String totalSalary(){
        int totalSalary = 0;
        for(WorkHuman human:dep) totalSalary += human.pay * human.getWorkTime();
        return "Need to pay the department: " + totalSalary + " RUB.";
    }
    
    public int size(){
        return dep.size();
    }
}
