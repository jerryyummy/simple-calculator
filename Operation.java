public class Operation {
    private double num1,num2;

    public double getResult(){
        return 0;
    }
    public double getNum1(){
        return num1;
    }
    public double getNum2(){
        return num2;
    }

    public void setNum1(double number){
        this.num1=number;
    }
    public void setNum2(double number){
        this.num2=number;
    }
}

class Oepration_Add extends Operation{
    public double getResult(){
        return getNum1()+getNum2();
    }
}
class Oepration_Sub extends Operation{
    public double getResult(){
        return getNum1()-getNum2();
    }
}
class Oepration_Mul extends Operation{
    public double getResult(){
        return getNum1()*getNum2();
    }
}
class Oepration_Div extends Operation{
    public double getResult(){
        return getNum1()/getNum2();
    }
}