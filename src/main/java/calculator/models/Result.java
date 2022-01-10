package calculator.models;


public class Result {

    String expression;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    String answer = "auf";

    public Result() {
    }

    public Result(String expression) {
        this.expression = expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
