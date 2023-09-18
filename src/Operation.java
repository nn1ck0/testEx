public interface Operation {
    public String sum(int secondOp);
    public String subtr(int secondOp) throws ResultException;
    public String multpl(int secondOp) throws ResultException;
    public String div(int secondOp);
    public int getOperand();
}
