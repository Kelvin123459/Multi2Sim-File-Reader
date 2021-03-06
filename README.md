# Multi2Sim-File-Reader
## Kelvin Garcia Muñiz
## To Run the Program:
Before executing any of these commands from the CMD or Terminal make sure you are in the correct directory path. If using Eclipse or a 
similar IDE, these procedures may not be required.
### To Run Main Program:
From terminal: java -classpath ./bin main/Main
    
       This command will execute the Main.java class and output results according to the data gotten from the input files. If 
       the execution is successful, the names of the files read will be displayed on the console.
       
       The execution of the program will be successful if the following conditions are satisfied:
       
          1. There is an input files directory under the name specified by the program.
         
               - In addition, there must be a dataFiles.txt file containing the names of the files to be tested.
          
          2. There is a directory under the name specified by the program ("outputFiles" by default) containing the
             output files of the program.
             
          3. The command is executed while in the correct directory path.
          
       * For detailed information head to the in-code implementation *
From IDE: Run Main.java from the main package
### To Run Files Generator:
From terminal: java -classpath ./bin tester/FilesGenerator

       This command will execute the FilesGeneratorMain.java class and output files according to specified parameters. 
       If the execution is sucessful, the amount of files executed will be displayed. The execution will be successful if:
       
        1. There is a directory under the name specified by the program ("inputFiles" by default).
          
        2. There is a directory under the name specified by the program.
             
        3. The command is executed while in the correct directory path.
       
     * For detailed information head to the in-code implementation *
From IDE: Run filesGeneratorMain.java from the generators package
## What the program is for:
This software was merely created to accelerate and automatize the data recollection process from files created by the Multi2Sim CPU & GPU simulator. 
### Main
The program's main purpose is to take specific data from files with a standard format and create .xls files with this information
### Files Generator
The program is able to generate data for testing. Included, there are sample files with information equivalent to that provided by the simulator. The program will generate testing files containing the same information of its respective sample file. These files will range (by default) from:
    
        1) Bandwidth: 256 - 4096
        
        2) Cores: 2 - 20
        
        3) Threads: 4 - 128
        
        4) Sizes 4 - 256
## NOTE
This program makes use of the Apache POI JAVA API in order to access and modify .xls file formats. Should any error occur regarding the imported libraries, head to the Apache POI project website (http://poi.apache.org/download.html) to download the required files. 

Before executing the program, make sure you have modified the input directory in the Main.java class and that you have no compiling errors with the project. By default, if the program is being run from an idea or without any arguments in the terminal, the program will proceed to read and write all the input and output files respectively. 
