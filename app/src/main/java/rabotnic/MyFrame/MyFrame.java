/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabotnic.MyFrame;

import javax.swing.JFrame;
import rabotnic.WorkHumanFullTime;

/**
 *
 * @author Баян
 */
public class MyFrame extends JFrame {
    MyPanel panel;
    
    public  MyFrame(MyPanel p){
        panel = p;
        setTitle("WorkerHuerker");
        add(panel);
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
