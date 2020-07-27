import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
        int size=16;
        private boolean isEqual;
        String[] strings={"7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                ".","0","+","="};
        Operation operation=null;//创建操作运算空对象
        String temp="";//保存运算符
        private JButton[] buttons=new JButton[size];
        private JTextField result_textField;
        JPanel panel;

        public Calculator(){
            isEqual=false;//判断之前储存符号是否是等于
            for (int i = 0; i <buttons.length ; i++) {
                buttons[i]=new JButton(strings[i]);
            }
            result_textField=new JTextField();
            panel=new JPanel();
            result_textField.setHorizontalAlignment(JTextField.RIGHT);//文字靠右显示
            result_textField.setText("");//初始化不显示文字
            result_textField.setForeground(Color.red);//设置文本框文字颜色
            result_textField.setBorder(BorderFactory.createCompoundBorder(//设置边框样式
                    BorderFactory.createLineBorder(Color.BLACK),
                    BorderFactory.createEmptyBorder(15,15,20,15)
            ));
            panel.setLayout(new GridLayout(4,4,10,10));
            this.add(result_textField,BorderLayout.NORTH);
            for (int i = 0; i <buttons.length ; i++) {
                panel.add(buttons[i]);
            }
            this.add(panel, BorderLayout.CENTER);

            for (int i = 0; i <buttons.length ; i++) {
                buttons[i].addActionListener(this);
            }

            setTitle("CALCULATOR(仅适用于简单四则运算)");
            setSize(600,400);
            setLocation(400,200);
            setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

        }
        private int judgeOperation(String s){//判断是否是运算符
            int flag=0;
            if ("+-*/".indexOf(s)!=-1)
                flag=1;
            return flag;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            String text_on_button=e.getActionCommand();//获取当前按钮文字
            if ("1234567890.=".indexOf(text_on_button)==-1){//是运算符号
                temp=text_on_button;//储存运算符号
                operation=OperationFactory.createOperate(text_on_button);
                operation.setNum1(Double.parseDouble(result_textField.getText()));//set操作数
                result_textField.setText("");//清空输入框
                isEqual=false;
            }
            else if(text_on_button.equals("=")){//等于符号
                if (!isEqual){//上一个符号不是等于
                    operation.setNum2(Double.parseDouble(result_textField.getText()));
                    if (operation.getNum2()==0&&temp.equals("/")){
                        JOptionPane.showMessageDialog(null,"除数不能为0");
                        result_textField.setText("");
                    }
                    else {//正常显示结果
                        double result=operation.getResult();
                        result_textField.setText(Double.toString(result));
                        isEqual=true;
                    }
                }
                else {//上一个出现的符号是等于
                    operation.setNum1(operation.getResult());//操作数1为上一个结果，操作数2不变
                    double result=operation.getResult();
                    result_textField.setText(Double.toString(result));
                }

            }
            else {//是数字或者小数点
                result_textField.setText(result_textField.getText()+text_on_button);
                isEqual=false;
            }

        }
}
