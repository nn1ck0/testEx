import java.util.Scanner;


public class Main {
    public static String calc(String input) throws SignException, ResultException {
        
        Operation objNum1 = null;
        Operation objNum2 = null;

        int flOfEx = 0;

        Expression newExp = new Expression(input);
        newExp.partitionExpression();

        try {

            Integer.parseInt(newExp.getFirsOpExp());
            try {
                Integer.parseInt(newExp.getSecondOpExp());
            } catch (NumberFormatException e) {
                System.out.println("На вход принимаются только целые арабские или только римские цифры!");
                System.exit(0);
            }

        } catch (NumberFormatException e) {
            try {
                Integer.parseInt(newExp.getSecondOpExp());
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

        return switch (newExp.getSignExp()) {
            case ("+") -> objNum1.sum(objNum2.getOperand());
            case ("-") -> objNum1.subtr(objNum2.getOperand());
            case ("*") -> objNum1.multpl(objNum2.getOperand());
            case ("/") -> objNum1.div(objNum2.getOperand());
            default -> throw new SignException("Ввели неверный знак!");
        };
    }

    public static void main(String[] args) throws SignException, ResultException {

        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));}

}

