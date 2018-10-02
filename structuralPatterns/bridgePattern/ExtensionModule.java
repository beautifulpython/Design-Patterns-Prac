import java.util.*;
public class ExtensionModule{
   //该public class 只是为了编译多个类而设
}
//现在我要加一个小米牌笔记本laptop
class Xiaomi implements Cbrand{
	public void showBrand(){
		System.out.print("  小米 ");
	}
}
	
class Laptop implements Ctype{
	public void showType(){
		System.out.print(" laptop ");
	}
}	