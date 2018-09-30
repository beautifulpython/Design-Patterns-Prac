import java.util.*;

/*
//1.shape factory
public class Main{
  public static void main(String[] args){
	ShapeFactory factory = new ShapeFactory();
	Shape cir = factory.getShapeIntance("circle");
	Shape rec = factory.getShapeIntance("rectangle");
	cir.draw();
	rec.draw();
  }  

}
  interface Shape{
	  void draw();
  }
  class Circle implements Shape{
	  public void draw(){
		  System.out.println("Draw a circle.");
	  }
  }
   class Rectangle implements Shape{
	  public void draw(){
		  System.out.println("Draw a rectangle.");
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
  */
  
  
//2.abstract factory pattern
public class Main{
  public static void main(String[] args){
	//just look like I always get elements from an all-purpose factory.
	AbstractFactory factory = new AbstractFactory();
	Shape cir = factory.getShape("circle");
	Color red = factory.getColor("red");
	cir.draw();red.fill();
	System.out.println("Now,I got a red circle~ ^^");
  }  

}

//shape
  interface Shape{
	  void draw();
  }
  class Circle implements Shape{
	  public void draw(){
		  System.out.println("Draw a circle.");
	  }
  }
   class Rectangle implements Shape{
	  public void draw(){
		  System.out.println("Draw a rectangle.");
	  }
  }

  
//color  
  interface Color{
	  void fill();
  }
  class Red implements Color{
	  public void fill(){
		  System.out.println("fill with red color.");
	  }
  }
    class Blue implements Color{
	  public void fill(){
		  System.out.println("fill with blue color.");
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