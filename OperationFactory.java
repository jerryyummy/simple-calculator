public class OperationFactory {//根据运算符创建不同类
    public static Operation createOperate(String operate){
        Operation operation=null;
        switch (operate){
            case "+":
                operation=new Oepration_Add();
                break;
            case "-":
                operation=new Oepration_Sub();
                break;
            case "*":
                operation=new Oepration_Mul();
                break;
            case "/":
                operation=new Oepration_Div();
                break;
        }
        return operation;
    }
}
