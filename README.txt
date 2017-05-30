This is a guide about how to run the cinema system on your computer in command line.
The software is coded based on java SE 1.8.0_101. Lower version of JAVA may cause error.
1. Introduction of the file directory
	launchGUI.java contains the main method.
	directory "pic" contains all picture files used in the system.
	directory "texts" contains all txt files that used to store the data used in the system, user's ticket generated is also store here.
2. Run the software
	1. Open command line and switch current work directory to directory "Cinema". e.g. D:\Cinema>
	2. Type "javac launchGUI.java" then press Enter and then there will automatically generate java classes.
	3. Type "java launchGUI" and press enter, and then the software will be launched.
	4. There will be serveral choices provided for you to help finishing the operation of buying tickets, Please follow the instruction displayed and input choices correctly.
	5. The system provides some "Exit" choices when using it that can help users close the software.Moreover, clicking the exit button of the window or using "Ctrl+C" in command line can terminate it, too. 
3. If it has some problem of displaying choices of screens of one film
	The main problem will be the time that use this software. Because as the handout says: "the customer can only purchase the ticket which show time is AFTER the current time". So if the time of your computer is later than the time of last film, there will be no display of film.