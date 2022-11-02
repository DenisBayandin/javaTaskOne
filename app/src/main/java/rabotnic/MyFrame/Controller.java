package rabotnic.MyFrame;

import rabotnic.*;




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
    
    public void createRegularWorkHuman(String name, int age, int pay, int workTime){
        department.addWorker(new WorkHumanFullTime(name, age, pay, workTime));
    }
    
    public void createHourWorkHuman(String name, int age, int pay, int workTime){
        department.addWorker(new WorkHumanHours(name, age, pay, workTime));
    }

    public void setWorkhumanName(String name){
       workhuman.setName(name);
    }
    
    public Department department(){
        return department;
    }
  
    public String getWorkhumanName(){
        return workhuman.getName();
    }
    
    
    public void setWorkhuman(WorkHuman workHuman){
        this.workhuman = workhuman;
    }
}