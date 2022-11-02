package rabotnic.MyFrame;


import static java.awt.Component.BOTTOM_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.*;
import rabotnic.WorkHuman;
import rabotnic.WorkHumanFullTime;
import rabotnic.WorkHumanHours;
import rabotnic.Department;

public class MyPanel extends JPanel implements Observer{
    JTextField nameField;
    JTextField ageField;
    JTextField payField;
    JTextField workTimeField;
    JButton enterRegularWorker;
    JButton enterHourWorker;
    JButton payButton;
    Controller controller;
    JLabel salaryLabel;
    JTextArea humanList;
    WorkHuman arr;
    
    public MyPanel(Controller contr){
        this.controller = contr;
        nameField = new JTextField("Worker name", 15);
        ageField = new JTextField("Worker age", 15);
        payField = new JTextField("Worker salary", 15);
        workTimeField = new JTextField("Worker time", 15);
        enterRegularWorker = new JButton("Create regular worker");
        enterHourWorker = new JButton("Create hour worker");
        payButton = new JButton("Show salary");
        payButton.setLayout(null);
        humanList = new JTextArea("There you can see your department workers", 1, 50);
        humanList.setEditable(false);
        salaryLabel = new JLabel("");
        add(nameField);
        add(ageField);
        add(payField);
        add(workTimeField);
        add(enterRegularWorker);
        add(enterHourWorker);
        add(humanList);
        add(payButton);
        payButton.setLocation(0, 0);
        add(salaryLabel);

        enterRegularWorker.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                int pay = Integer.parseInt(payField.getText().trim());
                int workTime = Integer.parseInt(workTimeField.getText().trim());
                controller.createRegularWorkHuman(name, age, pay, workTime);
                updateHumanList();
            }
            
        });
        
        enterHourWorker.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                int pay = Integer.parseInt(payField.getText().trim());
                int workTime = Integer.parseInt(workTimeField.getText().trim());
                controller.createHourWorkHuman(name, age, pay, workTime);
                updateHumanList();
            }
            
        });
        
        payButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String totalPayment = controller.department.totalSalary();
                salaryLabel.setText(totalPayment);
            }
            
        });
       
    }
    
    public void updateHumanList(){
        int count = controller.department.size();
        humanList.setRows(count);
        humanList.setText("");
        humanList.setLineWrap(true);
        for(int i = 0; i < count; i++){
            String text = controller.department.informationHuman(i) + "\n";
            text = text.replaceAll("\\\\n", System.getProperty("line.separator"));
            humanList.append(text);
        }
    }

    @Override
    public void update(Observable o, Object arg){
        WorkHumanFullTime workhum = (WorkHumanFullTime) o;
        nameField.setText("Name = " + workhum.getName());
//        ageField.setText("Age = " + workhum.getAge());
    }
}
