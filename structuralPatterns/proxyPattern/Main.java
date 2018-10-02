
//1.静态代理
import java.util.*;
interface Star {
    void confer();//面谈
    void signContract();//签合同
    void bookTicket();//订票
    void sing();//唱歌
    void collectMoney();//收尾款
}

class RealStar implements Star{
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }
    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }
    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }
    @Override
    public void sing() {
        System.out.println("张学友.sing()");//真实角色的操作：真正的业务逻辑
    }
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}

class ProxyStar implements Star{
    private Star star;//真实对象的引用（明星）
    @Override
    public void confer() {
        System.out.println("ProxyStar.confer()");
    }
    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");
    }
    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");
    }
    @Override
    public void sing() {
        star.sing();//真实对象的操作（明星唱歌）
    }
    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }
    public ProxyStar(Star star) {//通过构造器给真实角色赋值
        this.star = star;
    }
}

public class Main{
	public static void main(String[] args) {
    Star real = new RealStar();
    Star proxy = new ProxyStar(real);
    proxy.confer();
    proxy.signContract();
    proxy.bookTicket();
    proxy.sing();//真实对象的操作（明星唱歌）
    proxy.collectMoney();
}
	
}

/*
//2.动态代理
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
import java.util.*;
import java.lang.reflect.*;

public class Main{
 public static void main(String[] args) {
    //真实角色
    Star realStar = new RealStar();
    //处理器
    StarHandler handler = new StarHandler(realStar);
    //代理类
    Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
    proxy.sing();//调用代理类的唱歌方法：其实调用的是真实角色的唱歌方法
}
 
 }
//动态代理处理器
class StarHandler implements InvocationHandler{
  
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真实角色调用之前的处理.....");
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar, args);//激活调用的方法   
        }
        System.out.println("真实角色调用之后的处理.....");
        return object;
    }
    //通过构造器来初始化真实角色
    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }
}
//公共接口抽象
interface Star {
    void confer();//面谈
    void signContract();//签合同
    void bookTicket();//订票
    void sing();//唱歌
    void collectMoney();//收尾款
}
//真实演员
class RealStar implements Star{
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }
    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }
    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }
    @Override
    public void sing() {
        System.out.println("张学友.sing()");//真实角色的操作：真正的业务逻辑
    }
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}

*/

