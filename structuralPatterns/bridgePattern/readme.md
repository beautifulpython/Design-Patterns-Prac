桥接模式：
    1.background
	  抽象层(本例中GeneralComputer实现类就可以理解为一个抽象层桥接器)与实现层解耦。基本形式是 new(new());
	  一个抽象层可以有多个实现层，均可桥接至抽象层。比如电脑系列有两个维类度品牌和机型，可以分别写两个实现层。
	  比方说我要再加一个百度的量子计算机。那么需分别编写百度class去继承品牌class，编写量子计算机class继承机型class,其他类无需重新编译。
	  Computer c1 = new GeneralComputer(new 品牌(),new 机型()); 
	2.implement principle
	  a.define abstract class(not interface! but why?) which bring in the instances of Implementation class.
	  //在网上看到桥接模式都是用抽象类实现的，其实本质是为了实现多态的共同点构造，但是抽象类终归是不可实例化的，那为什么不做一个完全实现类来做桥接器呢？
	  //定义一个interface单单做能力描述会不会更好呢？我觉得接口+桥接器实现类可以完成同抽象类桥接器+某一实现类相同的功能，而后者的结构看上去不很清晰。
	  //本目录下完成了利用一个桥接器去桥接两种接口类来完成showName功能。也提供了baseModule和extensionModule两个模块类做一个简单的扩展演示。
	  b.You need to know how to javac many javaFiles.
    3.applicable scene and optimize
	  本模式样例设计到java多文件编译，这也是大多数设计模式的立足点，之前觉得太麻烦才都写在一个Main类里边，之后的设计模式样例编写都将与此样例类似。
	  
	
	Bridge pattern make extension be simple.