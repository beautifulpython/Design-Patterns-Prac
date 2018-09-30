import java.util.*;
//http://www.runoob.com/design-pattern/singleton-pattern.html
/*
//1.singleton pattern . NOT thread-safe!!!
public class Main{
  public static void main(String[] args){
	Singleton s1 = Singleton.getInstance();
	Singleton s2 = Singleton.getInstance();
	System.out.println(System.identityHashCode(s1));
	System.out.println(System.identityHashCode(s2));
	System.out.println(s1==s2);
	
  }  
}

  class Singleton {
	  private static Singleton instance = null;
	  private Singleton(){}
	  public static Singleton getInstance(){
		  if(instance == null) instance = new Singleton();
		  return instance;
	  }
  }
*/  
/*
//2.singleton pattern consider about concurrence. thread-safe.
public class Main{
  public static void main(String[] args){
	Singleton s1 = Singleton.getInstance();
	Singleton s2 = Singleton.getInstance();
	System.out.println(System.identityHashCode(s1));
	System.out.println(System.identityHashCode(s2));
	System.out.println(s1==s2);
	
  }  
}
//2a.double synchronized (lazy load)
  class Singleton {
	  private static Singleton instance = null;
	  private Singleton(){}
	  public static Singleton getInstance(){
		if (instance == null) {  
        synchronized (Singleton.class) {  
        if (instance == null) {  
            instance = new Singleton();  
        }  
        }  
    }  
		  return instance;
	  }
  }
  */
  /*
//2b.(not lazy load)
class Singleton {  
    private static Singleton instance = new Singleton();  //class loader will create instance , please consider memory cost.
    private Singleton (){}  
    public static Singleton getInstance() {  
    return instance;  
    }  
}
*/
//2c.enum
public class Main{
  public static void main(String[] args){
	Singleton s1 = Singleton.INSTANCE;
	Singleton s2 = Singleton.INSTANCE;
	s1.whateverMethod();
	s2.whateverMethod();
	System.out.println(System.identityHashCode(s1));
	System.out.println(System.identityHashCode(s2));
	System.out.println(s1==s2);
	
  }  
} 
enum Singleton {  
    INSTANCE;  
    public void whateverMethod() {  
	System.out.println("This is a method of INSTANCE.");
    }  
}
//*/