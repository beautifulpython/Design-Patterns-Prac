public class BaseModule{
	//just for convenience.
}

//����computer�������ӿ�
interface Computer{
	void showName();
}
//����ʵ���࣬���Ž�ʹ��
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

//brand ����ʵ����
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
//type ����ʵ����
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