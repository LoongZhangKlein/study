package study.designmodel.strategypattern;

/**
 * @author jiava
 * @Description DOING
 * @date 2022-12-01-17:18
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 执行策略模式的方法
     * @param num1
     * @param num2
     * @return
     */
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
