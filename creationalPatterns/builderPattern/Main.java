
import java.util.*;

import static java.lang.Thread.sleep;


//builder pattern + factory + protoType
/*
we suppose that a set meal contains burgers and beverages.
	*Burgers maybe a vegBurger or a chickenBurger.
	*Beverages maybe coke or fenta.
	*Both them need to be add to Item that may be used to assemble to be a set meal but they haven't been packaged.(just like what main func doing.)
*/
public class Main{
    public static void main(String[] args){
        MealBuilder Alina = new MealBuilder();
        Alina.orderVFsetMeal();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    System.out.println("Now , I ask Alina to order a VFsetMeal(vegBurger and fenta~~)."+'\n'+"You can ask someone else to make setMeals for you ,such as chicken_coke_meal?ahaaa^^");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     System.out.println("Honestly,I hava used singleton、abstractFactory、protoType and Builder design patterns to completed this task.(all creational design Patterns)");
    }

}

class MealBuilder{
    private List<Elements> mealList = new ArrayList<>();
    public void orderVFsetMeal(){

        Burgers bur = (Burgers)InstanceCache.getElem("VegBurger");
        System.out.println("Writress Alina start to make a VFsetMeal.Please wait a little moment. ^ ^");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Prepare a VegBurger....");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        Beverages coke = (Beverages)InstanceCache.getElem("fenta");
        System.out.println("Prepare a fenta....");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        mealList.add(bur);mealList.add(coke);
        System.out.println("Packing....");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        for(Elements e:mealList){
            e.pack();
        }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("VFmeal completed.");
    }
    public void orderCCsetMeal(){
        System.out.println("CCmeal need you to complete ,just a practice!.");
    }

}

class InstanceCache{
    private static Map<String,Elements> map = new HashMap<>();
    private InstanceCache(){}
    public static void loadCache(){ //create a table contains all Instances.
        if(map==null || map.isEmpty())
        {
            AbstractFactory factory = new AbstractFactory();
            //Here create all instance will be need(create these instances will be costful )
            Elements bur = factory.getBurger("chickenBurger");
            Elements rec = factory.getBurger("VegBurger");
            map.put("chickenBurger",bur);
            map.put("VegBurger",rec);
            Elements coke = factory.getBeverage("coke");
            Elements fenta = factory.getBeverage("fenta");
            map.put("coke",coke);
            map.put("fenta",fenta);
        }
        else{}
    }
    public static Elements getElem(String s){
        if(map==null || map.isEmpty())InstanceCache.loadCache();
        Elements ee = (Elements)map.get(s).clone();
        return ee;
    }
}

interface Packable {void pack();}
//interface abstract
interface Elements extends Cloneable,Packable{Elements clone();void pack();}
//shape
interface Burgers extends Elements{
    void pack();
}

class ChickenBurger implements Burgers{
    public void pack(){
        System.out.println("pack a chickenBurger with wrapper.");
    }
    public Burgers clone() {
        Burgers clone = null;
        try {
            clone = (Burgers) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
class VegBurger implements Burgers{
    public void pack(){
        System.out.println("pack a VegBurger with wrapper.");
    }

    public Burgers clone() {
        Burgers clone = null;
        try {
            clone = (Burgers) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}



//bottle
interface Beverages extends Elements{
    void pack();
}
class Coke implements Beverages{
    public void pack(){
        System.out.println("pack coke with bottle.");
    }
    public Beverages clone() {
        Beverages clone = null;
        try {
            clone = (Beverages) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
class Fenta implements Beverages{
    public void pack(){
        System.out.println("pack fenta with  bottle.");
    }
    public Beverages clone() {
        Beverages clone = null;
        try {
            clone = (Beverages) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}


//factory
class AbstractFactory{
    public Burgers getBurger(String s){
        return new BurgerFactory().getBurgerInstance(s);
    }
    public Beverages getBeverage(String c){
        return new BeverageFactory().getBeverageInstance(c);
    }
}

class BurgerFactory{
    public Burgers getBurgerInstance(String s){
        //if(s==null)return null;
        if(s.equalsIgnoreCase("chickenburger")){return new ChickenBurger();}
        else if(s.equalsIgnoreCase("vegburger")){return new VegBurger();}
        return null;
    }
}

class BeverageFactory {
    public Beverages getBeverageInstance(String s){
        //if(s==null)return null;
        if(s.equalsIgnoreCase("coke")){return new Coke();}
        else if(s.equalsIgnoreCase("Fenta")){return new Fenta();}
        return null;
    }
}
