package rabotnic.MyFrame;


import static java.awt.Component.BOTTOM_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.*;
import rabotnic.WorkHumanFullTime;
import rabotnic.WorkHumanHours;
import rabotnic.Department;

public class MyPanel extends JPanel implements Observer{
    JTextField nameField;
    JTextField ageField;
    JTextField payField;
    JTextField workTimeField;
    JButton enterButton;
    JButton payButton;
    Controller controller;
    JLabel salaryLabel;
    JTextArea humanList;
    JComboBox<String> typeSelect;
    
    public MyPanel(Controller contr){
        this.controller = contr;
        nameField = new JTextField("Worker name", 15);
        ageField = new JTextField("Worker age", 15);
        payField = new JTextField("Worker salary", 15);
        workTimeField = new JTextField("Worker time", 15);
        String[] types = { "Regular", "Hour" };
        typeSelect = new JComboBox<>(types);
        enterButton = new JButton("Create worker");
        payButton = new JButton("Show salary");
        payButton.setLayout(null);
        humanList = new JTextArea("There you can see your department workers", 1, 50);
        humanList.setEditable(false);
        salaryLabel = new JLabel("");
        add(nameField);
        add(ageField);
        add(payField);
        add(workTimeField);
        add(typeSelect);
        add(enterButton);
        add(humanList);
        add(payButton);
        payButton.setLocation(0, 0);
        add(salaryLabel);
        
        
        enterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                int pay = Integer.parseInt(payField.getText().trim());
                String type = (String) typeSelect.getSelectedItem();
                int workTime = Integer.parseInt(workTimeField.getText().trim());
                controller.createWorkHuman(name, age, pay, type, workTime);
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
        
//        button.addActionListener(new ActionListener (){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                contoller.setWorkhumanName(field.getText().trim());
//            }
//        });
        
//        button.addActionListener(new ActionListener (){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                JLabel[] labels = new JLabel[count];
//                for(int i = 0; i < count; i++){
//                    labels[i] = new JLabel();
//                    labels[i].setText(contoller.dep.salary_depor()); 
//                    add(labels[i]);
//                    System.out.println(labels[i].getText());
//                }
//            }
//        });
//
//            JLabel[] labels = new JLabel[count];
//                for(int i = 0; i < count; i++){
//                    System.out.println("RABOTAET");
//                    labels[i] = new JLabel();
//                    labels[i].setText("" + contoller.dep.speak_no_for(0)); 
//                    labels[i].getHorizontalAlignment();
//                    add(labels[i]);
////                    System.out.println(labels[i].getText());
//                }
       
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
