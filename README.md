# Assignment 9 - File Finder

## Overview
In this assignment you will create a program that searches the file system looking for all occurances of a file with the name you provide it.  Your program will then print the number of times it found a file with that name.  You will execute your program by providing it the name of the file you want to find and the directory you want it to begin searching from.  The program will recursively search the entire directory tree under the directory you provided it.

The program will be able to run in verbose mode or regular mode.  When running in verbose mode, the path to each file (relative to the directory provided) will be printed along with the size of the file in bytes (in addition to the total number of files found).  When running in regular mode, only the total number of files found will be printed.

During execution of your program, any files encountered that are not readable will have their full path printed to an error file.  The name of this error file and the mode your program is running in (verbose mode or regular mode) will be determined based on a configuration file called "config.txt" (see more in the Input section).

## Assignment Submission
You will submit your assignment using GitHub Classroom.  When you are finished and want to make your final submission, use the checkin comment "FINAL SUBMISSION":

        git add .
        git commit -m "FINAL SUBMISSION"
        git push origin main

Any submission not having this comment will be assumed to be a work-in-progress and therefore will be ignored.  This implies that you must make your final push with this commit comment before the deadline.

## Input
The configuration file is called "config.txt" and contains 2 parameters specfied on separate space-delimited lines.  Your program should read the file token-by-token with the first token on each line being the name of the parameter and the second being the value.  For example, the following "config.txt" contents indicate that the error messages should be stored in a file called "errors.txt" and the program should run in verbose mode:

~~~~
logFile errors.txt
verboseMode true
~~~~

In addition to this, your program will take two command line parameters.  The first indicates the root directory at which the file search will begin and the second is the name of the file your program should search for.  For example, to search for all files named "README.txt" beginning in your home directory, you would invoke the program in the following way:

~~~~
$ java FileFinder ~ README.txt
~~~~

## Output
Your program should produce the following output EXACTLY.

	Example 1:
	----------
	- The program is executed looking for "FileFinder.java" in /tmp after executing
	  the program, the errors.txt file contains an error message for each file
	  encountered that was not readable. The contents of the configuration file are
	  also show.

	$ cat config.txt 
	logFile errors.txt
	verboseMode true

	$ java FileFinder /tmp FileFinder.java
	Total number of matches 0

	$ cat errors.txt 
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-logind.service-nGEeSi was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-switcheroo-control.service-Ui7h7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-upower.service-Hftsqj was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-colord.service-9GVVei was not readable
	/tmp/tracker-extract-files.125 was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-resolved.service-yxCQ3h was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-ModemManager.service-mnnp7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-timesyncd.service-Wl14Mg was not readable
	/tmp/snap.snap-store was not readable


	Example 2:
	----------
	- The program is executed looking for FileFinder.java in the user's home directory.
	  The configuration file indicated that verbose mode should be disabled.
	  Therefore, only the number of matches is printed. Note, in this case, there were
	  no errors so the error file is empty.  The contents of the configuration file are
	  also show.

	$ cat config.txt 
	logFile errors.txt
	verboseMode false

	$ java FileFinder ~ FileFinder.java
	Total number of matches 1


	Example 3:
	----------
	- The program is executed looking for README.txt in the user's home directory.
	  The configuration file indicated that verbose mode should be enabled.
	  Therefore, the number of matches is printed in addition to the details of each
	  match are printed. Note, in this case, there were no errors so the error file
	  is empty.  The contents of the configuration file are also show.

	$ cat config.txt 
	logFile errors.txt
	verboseMode true

	$ java FileFinder ~ README.txt
	Total number of matches 28
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a6/README.txt (2439 bytes)
	/home/cscstudent/repos/solutions/csc106/a6/README.txt (2439 bytes)
	/home/cscstudent/repos/solutions/csc106/a9/README.txt (7034 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a5/README.txt (3258 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a8/README.txt (6375 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a3/README.txt (3595 bytes)
	/home/cscstudent/repos/solutions/csc106/a2/README.txt (3274 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a2/README.txt (3274 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a7/README.txt (3733 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a6/README.txt (2439 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a7/README.txt (3733 bytes)
	/home/cscstudent/repos/solutions/csc106/a7/README.txt (3733 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a8/README.txt (6375 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a4/README.txt (2548 bytes)
	/home/cscstudent/repos/solutions/csc106/a3/README.txt (3595 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a3/README.txt (3595 bytes)
	/home/cscstudent/repos/solutions/csc106/a4/README.txt (2548 bytes)
	/home/cscstudent/repos/solutions/csc106/a8/README.txt (6375 bytes)
	/home/cscstudent/spring2022Examples/README.txt (372 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a1/README.txt (1577 bytes)
	/home/cscstudent/Desktop/README.txt (1403 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a4/README.txt (2548 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a5/README.txt (3258 bytes)
	/home/cscstudent/repos/solutions/csc214/assignment6/README.txt (2725 bytes)
	/home/cscstudent/repos/solutions/csc106/a5/README.txt (3258 bytes)
	/home/cscstudent/repos/ta-solution/judson-solutions-csc106-S2022/a1/README.txt (1577 bytes)
	/home/cscstudent/repos/starter/judson-starter-csc106-S2022/a2/README.txt (3274 bytes)
	/home/cscstudent/repos/solutions/csc106/a1/README.txt (1577 bytes)

        Example 4:
        ----------
        - The program is set to verbose mode but the permissions on the configuration file
	  have been set so that it's not readable. Therefore, when the program is executed
          if fails to read the configuration and falls back to the default mode of verbose
          output and logging errors to STDOUT.

	$ cat config.txt 
	logFile errors.txt
	verboseMode true

	$ chmod 244 config.txt 
	$ cat config.txt 
	cat: config.txt: Permission denied

	$ java FileFinder /tmp README.txt 
	Config file could not be read, falling back to default mode
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-fwupd.service-HwTnsg was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-logind.service-nGEeSi was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-switcheroo-control.service-Ui7h7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-upower.service-Hftsqj was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-colord.service-9GVVei was not readable
	/tmp/tracker-extract-files.125 was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-resolved.service-yxCQ3h was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-ModemManager.service-mnnp7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-timesyncd.service-Wl14Mg was not readable
	/tmp/snap.snap-store was not readable
	Total number of matches 0

        Example 5:
        ----------
        - The program is unable to create a new error file because the is already one existing with
          read-only permissions (so it cannot be overwritten). Your program detects this at the time
	  it tries to create the output file (an IOException) and sends the error messages to STDOUT
          instead.

        $ cat config.txt
        logFile errors.txt
        verboseMode true

	$ chmod 444 errors.txt 

	$ echo >> errors.txt 
	bash: errors.txt: Permission denied

	$ java FileFinder /tmp README.txt 
	Error opening errors.txt errors will be logged to STDOUT.
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-fwupd.service-HwTnsg was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-logind.service-nGEeSi was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-switcheroo-control.service-Ui7h7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-upower.service-Hftsqj was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-colord.service-9GVVei was not readable
	/tmp/tracker-extract-files.125 was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-resolved.service-yxCQ3h was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-ModemManager.service-mnnp7g was not readable
	/tmp/systemd-private-ddd88e673a4d47119401b37457d43114-systemd-timesyncd.service-Wl14Mg was not readable
	/tmp/snap.snap-store was not readable
	Total number of matches 0

## Implementation Notes
1.) IOException - Your program could encounter an IOException if it tries to read
    or write a file that is not readable or writeable.  You should handle each
    Exception gracefully as shown in example 4 and 5 above by printing the
    approrpiate error message and falling back to the default configuration
    described in each example.
2.) Symbolic links - your program should only consider a Path to be a match if it
    is not a Symbolic Link (hint: look at the javadoc for the Files class).
