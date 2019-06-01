#1 create UUID folder
#2 get Input string (it's a file)
#3 generate the testing solution
#4 execute it and compare with correct solution result.
#5 


Schema design
## I always like entity first way. code first not work for me.
## using mysql or sqlite, sqlite for local only, mysql can be a website

### Problem table
1) Problem 
	ID
	Subject
	Description
	StandardSolutionCode
	TestCaseCode
	
2) Solution  
	ID
	ProblemID
	Description
	Review
 	Score
 	SourceCode
 
          