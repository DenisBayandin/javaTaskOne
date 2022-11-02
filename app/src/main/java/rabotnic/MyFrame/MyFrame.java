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
        setTitle("Worker Human");
        add(panel);
        setSize(1300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
