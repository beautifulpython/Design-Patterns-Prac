原型模式：
    1.background
	  创建对象开销较大时，为了提升性能。提前创建所有对象并存在Map里边，如果需要重复创建对象，则从map取一个克隆出来。
	2.implement principle
	  a.define abstract class/interface that implements Cloneable and overwrite clone()
	  b.define cachetype class contains a hashTable which store all Intance maybe need.
    3.applicable scene and optimize
	  Actually,all class or interface should be public.
	  if you want to add a class to describe another requirement,you need add your class and modify the factory class.
	  
	POINT:user who write a main func need to know which intance can be builded via factory but doesn't need to know how to build.
	
	
	A powful factory let things be simple.