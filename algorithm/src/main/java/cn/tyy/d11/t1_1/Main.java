package cn.tyy.d11.t1_1;

public class Main {
}
//测试抽象类继承的方法覆盖问题
class Test{
    public static void main(String[] args) {
        try{
            System.out.println("A");
            throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("B");
        }finally {
            System.out.println("c");
        }
    }
}

abstract class Base{
    abstract void m1();
    abstract void m2();
}

abstract class Sub extends Base{
    public  void m1(){
        System.out.println("m1");
    }
    public abstract void m2();
}