import java.util.*;


//1.Computer bridge brand and type  ------->common func showName!!!
public class Main{
  public static void main(String[] args){
	Computer c1 = new GeneralComputer(new Lenovo(),new Pc());
	c1.showName();
	//extension 小米笔记本
	Computer c2 = new GeneralComputer(new Xiaomi(),new Laptop());
	c2.showName();
  }  

}
