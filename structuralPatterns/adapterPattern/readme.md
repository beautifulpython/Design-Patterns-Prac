适配器模式：
    1.background
	  解决接口不统一的类之间的调用。作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。
	  
	2.implement principle
	  a.define adapter class which contains instance which is from be-adapted class and extends adapted class.
	 
    3.applicable scene and optimize
	  
	  
	POINT:Getting the be-adapted instance is equal to getting its ability(This job is implemented by adapter class).
	      Adapter class should be compatible with apated class(This is a good way to design).
	
	
	A bridge connects everything.
	And , the adapter just like a mandatary.
	(why not give instance to adapted class??
	(This is already the case ,graft flowers on a tree maybe the simplest way in the light of present situation))