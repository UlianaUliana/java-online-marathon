//Implement class ParallelCalculator that will be able to execute an operation in parallel thread.
//Use the implementation of Runnable for this.
//Constructor of ParallelCalculator should take 3 parameters:
//BinaryOperator<Integer> to define an operation that will be executed,
//int operand1 and int operand2.
//ParallelCalculator class should have not private int result field where the result
// of the operation will be written when it's executed.


import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {
    int result;
    int operand1;
    int operand2;
    BinaryOperator<Integer> operator;
    public ParallelCalculator(BinaryOperator<Integer> operator, int operand1, int operand2){
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run(){
        result = operator.apply(operand1, operand2);
    }
}
