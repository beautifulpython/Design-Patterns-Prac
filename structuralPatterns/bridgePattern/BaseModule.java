public class BaseModule{
	//just for convenience.
}

//定义computer的能力接口
interface Computer{
	void showName();
}
//基础实现类，供桥接使用
class GeneralComputer implements Computer{
	private Cbrand cbrand ; 
	private Ctype ctype;
    public GeneralComputer(Cbrand cbrand,Ctype ctype){
		this.cbrand=cbrand;
		this.ctype=ctype;
	}
	public void showName(){
		cbrand.showBrand();
		ctype.showType();
	}
	}

//brand 及其实现类
interface Cbrand {
	void showBrand();
}
class Lenovo implements Cbrand{
	public void showBrand(){
		System.out.print("Lenovo ");
	}
}
class Dell implements Cbrand{
	public void showBrand(){
		System.out.print("Dell ");
	}
}
//type 及其实现类
interface Ctype{
	void showType();
}
class Pad implements Ctype{
	public void showType(){
		System.out.print("pad ");
	}
}
class Pc implements Ctype{
	public void showType(){
		System.out.print("pc ");
	}
}