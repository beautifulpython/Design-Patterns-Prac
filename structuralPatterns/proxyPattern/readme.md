代理模式：
    1.background
	  提供访问控制或者包装处理。
	  a、比如一个功能类Func包含所有的微服务功能。user用户只能访问某些特定功能，那么就写一个proxyFuncForUser类提供接口去调用func的某些类。
	  b、调用某个微服务功能，需要做一些预处理和后处理，则可将这些包装到代理类的接口方法，避免对Func功能性污染。
	  
	2.implement principle
	  a.define abstract class/interface which describe what these Instance can do.---->abstract class/interface 
	  b.define porxy class which contains instance of realClass.
	 
    3.applicable scene and optimize
	  a.静态代理
	  b.动态代理