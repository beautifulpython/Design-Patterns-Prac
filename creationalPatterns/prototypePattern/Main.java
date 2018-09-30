import java.util.*;

//prototype pattern
public class Main{
  public static void main(String[] args){
	InstanceCache.loadCache();
	Shape cir = (Shape)InstanceCache.getElem("rectangle");
	Color red = (Color)InstanceCache.getElem("blue");
	//Elements cir = InstanceCache.getElem("circle");
	//Elements red = InstanceCache.getElem("red");
	cir.draw();red.fill();
	System.out.println("Now,I got a blue rectangle  via just clone from a map~(protoType pattern) ^^");
  }  

}
  
  class InstanceCache{
	  private static Map<String,Elements> map = new HashMap<>();
	  public static void loadCache(){ //create a table contains all Instances.
		  AbstractFactory factory = new AbstractFactory();
		//Here create all instance will be need(create these instances will be costful )
		Elements cir = factory.getShape("circle");
		Elements rec = factory.getShape("rectangle");
		map.put("circle",cir);
		map.put("rectangle",rec);
		Elements red = factory.getColor("red");
		Elements blue = factory.getColor("blue");
		map.put("red",red);
		map.put("blue",blue);
	  }
	  public static Elements getElem(String s){
		  return (Elements)map.get(s).clone();
	  }
  }
  
//interface abstract
  interface Elements extends Cloneable{Elements clone();}  
//shape
  interface Shape extends Elements{
	  void draw();
  }
  
  class Circle implements Shape{
	  public void draw(){
		  System.out.println("Draw a circle.");
	  }
	  public Shape clone() {
		Shape clone = null;
		try {
			clone = (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
  }
   class Rectangle implements Shape{
	  public void draw(){
		  System.out.println("Draw a rectangle.");
	  }
	  
	  public Shape clone() {
		Shape clone = null;
		try {
			clone = (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
  }
  

  
//color  
  interface Color extends Elements{
	  void fill();
  }
  class Red implements Color{
	  public void fill(){
		  System.out.println("fill with red color.");
	  }
	  public Color clone() {
		Color clone = null;
		try {
			clone = (Color) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}	  
  }
    class Blue implements Color{
	  public void fill(){
		  System.out.println("fill with blue color.");
	  }
	  public Color clone() {
		Color clone = null;
		try {
			clone = (Color) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}		  
  }

  
//factory
class AbstractFactory{
	public Shape getShape(String s){
		return new ShapeFactory().getShapeIntance(s);
	}
	public Color getColor(String c){
		return new ColorFactory().getColorIntance(c);
	}
}

  class ShapeFactory{
	  public Shape getShapeIntance(String s){
		//if(s==null)return null;
		if(s.equalsIgnoreCase("CIRCLE")){return new Circle();} 
		else if(s.equalsIgnoreCase("RECTANGLE")){return new Rectangle();} 
		return null;
   }
  }  

  class ColorFactory {
	  public Color getColorIntance(String s){
		//if(s==null)return null;
		if(s.equalsIgnoreCase("RED")){return new Red();} 
		else if(s.equalsIgnoreCase("Blue")){return new Blue();} 
		return null;
   }
  }  