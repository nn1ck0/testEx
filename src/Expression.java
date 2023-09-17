public class Expression {
    private String exp;
    private String[] partOfExp;


    public Expression(String exp) {
        this.exp = exp;
    }
    void partitionExpression() throws SignException {
        partOfExp = this.exp.split(" ");
        if (partOfExp.length != 3) throw new SignException("Формат математической операции не удовлетворяет!");
    }
    void setExp(String exp){
        this.exp = exp;
    }

    String getFirsOpExp() {
        return this.partOfExp[0];
    }
    String getSecondOpExp() {
        return this.partOfExp[2];
    }
    String getSignExp() {
        return this.partOfExp[1];
    }


}
