import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws RomanNumException, SignException {
        Scanner in = new Scanner(System.in);

        Operation objNum1 = null;
        Operation objNum2 = null;

        int result;
        int flOfEx = 0;

        Expression newExp = new Expression(in.nextLine());
        newExp.partitionExpression();

        try {

            int i = Integer.parseInt(newExp.getFirsOpExp());
            try {
                int k = Integer.parseInt(newExp.getSecondOpExp());
            } catch (NumberFormatException e) {
                System.out.println("На вход принимаются только целые арабские или только римские цифры!");
                System.exit(0);
            }

        } catch (NumberFormatException e) {
            try {
                int j = Integer.parseInt(newExp.getSecondOpExp());
                System.out.println("На вход принимаются только целые арабские или только римские цифры!");
                System.exit(0);
            } catch (NumberFormatException i) {
                for (RomanNum num : RomanNum.values()) {
                    if (num.toString().equals(newExp.getFirsOpExp())) {
                        flOfEx++;
                    }
                    if (num.toString().equals(newExp.getSecondOpExp())) {
                        flOfEx++;
                    }
                }
                if ((flOfEx == 0) | (flOfEx == 1)) {
                    System.out.println("На вход принимаются только целые арабские или только римские цифры!");
                    System.exit(0);
                }
            }
        }

        if (flOfEx == 2) {
            for (RomanNum num : RomanNum.values()) {
                if (num.toString().equals(newExp.getFirsOpExp())){
                    objNum1 = num;
                }
                if (num.toString().equals(newExp.getSecondOpExp())){
                    objNum2 = num;
                }
            }

        } else {
            objNum1 = new ArabicNum(Integer.parseInt(newExp.getFirsOpExp()));
            objNum2 = new ArabicNum(Integer.parseInt(newExp.getSecondOpExp()));
        }

        switch (newExp.getSignExp()) {
            case ("+"):
                result = objNum1.sum(objNum2.getOperand());
                objNum1.printResult(result);
                break;
            case ("-"):
                result = objNum1.subtr(objNum2.getOperand());
                if ((result < 1) & (flOfEx == 2)) {
                    throw new RomanNumException("В римских цифрах не может быть отрицательных чисел или 0");
                }
                objNum1.printResult(result);
                break;
            case ("*"):
                result = objNum1.multpl(objNum2.getOperand());
                if ((result > 100) & (flOfEx == 2)) {
                    throw new RomanNumException("Максимальная римская цифра в данном калькуляторе - C (100)!");
                }
                objNum1.printResult(result);
                break;
            case ("/"):
                if (objNum2.getOperand() == 0) throw new SignException("Деление на 0 запрещено!");
                else {
                result = objNum1.div(objNum2.getOperand());
                objNum1.printResult(result);
                break;}
            default:
                throw new SignException("Ввели неверный знак!");
        }
    }
}

