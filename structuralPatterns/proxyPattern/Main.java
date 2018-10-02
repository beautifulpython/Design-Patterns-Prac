
//1.��̬����
import java.util.*;
interface Star {
    void confer();//��̸
    void signContract();//ǩ��ͬ
    void bookTicket();//��Ʊ
    void sing();//����
    void collectMoney();//��β��
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
        System.out.println("��ѧ��.sing()");//��ʵ��ɫ�Ĳ�����������ҵ���߼�
    }
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}

class ProxyStar implements Star{
    private Star star;//��ʵ��������ã����ǣ�
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
        star.sing();//��ʵ����Ĳ��������ǳ��裩
    }
    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }
    public ProxyStar(Star star) {//ͨ������������ʵ��ɫ��ֵ
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
    proxy.sing();//��ʵ����Ĳ��������ǳ��裩
    proxy.collectMoney();
}
	
}

/*
//2.��̬����
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
import java.util.*;
import java.lang.reflect.*;

public class Main{
 public static void main(String[] args) {
    //��ʵ��ɫ
    Star realStar = new RealStar();
    //������
    StarHandler handler = new StarHandler(realStar);
    //������
    Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
    proxy.sing();//���ô�����ĳ��跽������ʵ���õ�����ʵ��ɫ�ĳ��跽��
}
 
 }
//��̬��������
class StarHandler implements InvocationHandler{
  
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("��ʵ��ɫ����֮ǰ�Ĵ���.....");
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar, args);//������õķ���   
        }
        System.out.println("��ʵ��ɫ����֮��Ĵ���.....");
        return object;
    }
    //ͨ������������ʼ����ʵ��ɫ
    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }
}
//�����ӿڳ���
interface Star {
    void confer();//��̸
    void signContract();//ǩ��ͬ
    void bookTicket();//��Ʊ
    void sing();//����
    void collectMoney();//��β��
}
//��ʵ��Ա
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
        System.out.println("��ѧ��.sing()");//��ʵ��ɫ�Ĳ�����������ҵ���߼�
    }
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}

*/

