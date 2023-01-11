package study.designmodel.strategypattern;

/**
 * @author jiava
 * @Description DOING
 * @date 2022-12-01-17:16
 */
public class OperationAdd implements Strategy{


    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
