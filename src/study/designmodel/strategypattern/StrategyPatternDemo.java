package study.designmodel.strategypattern;

/**
 * 策略模式的方法总结(感觉和工厂模式类似)
 * 弊端一: 也就是需要知道每个类的存在
 * 弊端二:当算法过多时,导致类增加,太过臃肿
 * step1:
 * 创建通用接口
 * step2:
 * 创建接口实现类
 * step3:
 * 实例化接口传参进行使用
 *
 */
public class StrategyPatternDemo {

   public static void main(String[] args) {
      Context context = new Context(new OperationAdd());    
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
      context = new Context(new OperationSubtract());      
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
   }
}