class ArabicNum implements Operation{
    private int operand;



    public ArabicNum() {
        this.operand = 0;
    }

    public ArabicNum(int operand) {
        this.operand = operand;

    }

    public void setOperand(int operand) {
        this.operand = operand;
    }
    @Override
    public int getOperand() {
        return operand;
    }


    @Override
    public int sum(int secondOp) {
        return this.operand + secondOp;
    }

    @Override
    public int subtr(int secondOp) {
        return this.operand - secondOp;
    }

    @Override
    public int multpl(int secondOp) {
        return this.operand * secondOp;
    }

    @Override
    public int div(int secondOp) {
        return this.operand / secondOp;
    }

    @Override
    public void printResult(int result){
        System.out.println(result);
    }


}
