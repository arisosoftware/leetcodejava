# Process
1 create UUID folder
2 get Input string (it's a file)
3 generate the testing solution
4 execute it and compare with correct solution result.
 
## the evaluation process will handel by python, 
previous I am thinking using java to do this job, but looks like python is more suitable .
### java version

That can be done using It can be done using JavaCompiler interface and ToolProvider class. If you have a class org.test.HelloWorld then you can compile it like this -

 JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
  // Compiling the code
  int result = compiler.run(null, null, null, 
     "C:\\workspace\\Test\\src\\org\\test\\HelloWorld.java");
  System.out.println("result " + result);
  // Giving the path of the class directory where class file is generated..
  File classesDir = new File("C:\\workspace\\Test\\bin\\org\\test");
  // Load and instantiate compiled class.
  URLC...
  
  
#Schema design
 I always like entity first way. code first not work for me.
 using mysql or sqlite, sqlite for local only, mysql can be a website

1) Problem 
*	ID
*	Subject
*	Description
*	StandardSolutionCode
*	TestCaseCode
	
2) Solution  
*	ID
*	ProblemID
*	Description
*	Review
*	Score
* 	SourceCode
 
          
          
## Next step
we need to add web interface, similar like leetcode website.
consider:
* ✍ Halo 可能是最好的 Java 博客系统  https://github.com/halo-dev
* ✍ 一款用 Java 实现的现代化社区（论坛/BBS/社交网络/博客）平台。    https://github.com/b3log/symphony
* ✍ https://github.com/Karthickramk/blogger

References
https://github.com/CyC2018/CS-Notes
https://www.geeksforgeeks.org/different-ways-to-sort-an-array-in-descending-order-in-c-sharp/
https://docs.microsoft.com/en-us/dotnet/api/
https://leetcode.com/problemset/all/

