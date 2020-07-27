import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorDemo {
    public static void main(String[] args) {
        Font font1 = new Font("Times New Roman",Font.ITALIC,24);
        Font font2 = new Font("Century Gothic",Font.BOLD,28);
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//设置外观
            UIManager.put("Button.font", font1);//设置字体
            UIManager.put("TextField.font", font2);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Calculator();
    }
}