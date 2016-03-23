Requirements : 
Java 8
All other .jar files are provided.

There are multiple ways to run SortAlgo. Please read and select which method is applicable to you.
	1) Run the Precompiled .jar file.
		To run SortAlgo for the .jar file double click the 'SortAlgo.jar' to start the program.
		Or in the command line run:
			java -jar sortAlgo.jar

	2) Compile and run the code yourself. 
		To compile the prorgam yourself with java 8.
		The following commands are to be executed in the command line in the current directory of:
		http://codex.cs.bham.ac.uk/svn/team-project/F5/final/

		To comiple run the following command :
		javac sortAlgoFX/*.java

		Then to start the program :
		java sortAlgoFX.Main

To run the Junit testing (Mac OSX , Linux)
javac -cp junitTesting/junit.jar:junitTesting/hamcrest-core-1.3.jar ./sortAlgoFX/*.java junitTesting/*.java

java -cp .:junitTesting/junit.jar:junitTesting/hamcrest-core-1.3.jar org.junit.runner.JUnitCore junitTesting.SortAlgosTest

To run the Junit testing (Windows)
javac -cp junitTesting/junit.jar;junitTesting/hamcrest-core-1.3.jar ./sortAlgoFX/*.java junitTesting/*.java

java -cp .;junitTesting/junit.jar;junitTesting/hamcrest-core-1.3.jar org.junit.runner.JUnitCore junitTesting.SortAlgosTest


Viewing the code.
	To view the code simply navigate indise of the F5/final/sortAlgoFX/ directory then open any of the .java files in a text editor of your choice.

