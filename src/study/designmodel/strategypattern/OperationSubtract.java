package study.designmodel.strategypattern;

/**
 * think in my option
 * 把这些方法放进一个抽象类中不可以吗
 */
public class OperationSubtract implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 - num2;
   }
}