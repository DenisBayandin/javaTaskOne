package rabotnic.MyFrame;

import rabotnic.WorkHumanFullTime;
import rabotnic.Department;
import rabotnic.WorkHumanHours;



public class Controller {
    MyPanel panel;
    MyFrame frame;
    WorkHumanFullTime workhuman;
    Department department;
    
    public Controller(){
        WorkHumanFullTime workhuman = new WorkHumanFullTime("Dima", 23, 500, 21);
        department = new Department();
        panel = new MyPanel(this);
        frame = new MyFrame(panel);
        workhuman.addObserver(panel);
//        department.addWorker(workhuman);
        
    }
    
    public void createWorkHuman(String name, int age, int pay, String type, int workTime){
        if ("Regular".equals(type)){
            department.addWorker(new WorkHumanFullTime(name, age, pay, workTime));
        }
        else{
            department.addWorker(new WorkHumanHours(name, age, pay, workTime));
        }
    }

    public void setWorkhumanName(String name){
       workhuman.setName(name);
    }
    
    public Department department(){
        return department;
    }
//    
//    public void setWorkhumanAge(int age){
//       workhuman.setAge(age);
//    }
//    
    public String getWorkhumanName(){
        return workhuman.getName();
    }
//    
//    public int getWorkhumanAge(){
//        return workhuman.getAge();
//    }
//    
//    public int getHumanPay(){
//        return workhuman.pay();
//    }
//    
//    abstract void speak();
}