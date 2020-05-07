//Suppose, you have class from task1 ParallelCalculator that is able to execute an operation
// in separate thread.
//It uses an implementation of Runnable for this.
//Constructor of ParallelCalculator takes 3 parameters:
//BinaryOperator<Integer> to define an operation that will be executed,
//int operand1 and int operand2.
//ParallelCalculator class has not private int result field where the result of the operation
// is written when operation is executed.
//
//You need to create Accountant class with a static method sum that takes 2 int parameters
// and returns their sum. The sum must be evaluated in a separate thread (please, do not call
// run() method of ParallelCalculator. Use start() on Thread object). Use ParallelCalculator for this. Method sum doesn't throw any checked exceptions.
//Using Thread.sleep() is unwelcomed in this task.


class Accountant{
    public static int sum(int x, int y){
        BinaryOperator<Integer> plus = (value1, value2) -> value1 + value2;
        ParallelCalculator calculator = new ParallelCalculator(plus, x, y);
        Thread t = new Thread(calculator);
        t.start();
        try {
            t.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        return calculator.result;
    }
}
