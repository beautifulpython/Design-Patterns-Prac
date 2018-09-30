单例模式：
    1.background
	  保证对象只被创建一次（主要解决：一个全局使用的类频繁地创建与销毁导致的不必要的开销）。
	  a.比如服务器端管理学院的首页cookie，再次访问不需要再创建同样的对象。
	  b.要求生产唯一序列号。 
	  c、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 
	  d、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
	2.implement principle
	  a.class constructor must be private and static.
	  b.class has a static  field instance that belong to itself.
	  c.class has a public method to provide this instance.
    3.applicable scene and optimize
	  You need consider about concurrence.
	  
	POINT:Always , some global scene or some restrictive scene will use singleton pattern.
	
	