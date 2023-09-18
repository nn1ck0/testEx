class ArabicNum implements Operation{
    private final int operand;



    public ArabicNum() {
        this.operand = 0;
    }

    public ArabicNum(int operand) {
        this.operand = operand;

    }

    @Override
    public int getOperand() {
        return operand;
    }


    @Override
    public String sum(int secondOp) {
        return Integer.toString(this.operand + secondOp);
    }

    @Override
    public String subtr(int secondOp) {
        return Integer.toString(this.operand - secondOp);
    }

    @Override
    public String multpl(int secondOp) {
        return Integer.toString(this.operand * secondOp);
    }

    @Override
    public String div(int secondOp) {
        if (secondOp != 0) {return Integer.toString(this.operand / secondOp);}
        else throw new ArithmeticException("Деление на 0 запрещено!");
    }


}
