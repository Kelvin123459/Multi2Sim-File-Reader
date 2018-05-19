# Multi2Sim-File-Reader
## Kelvin Garcia Muñiz

## To Run the Program:
Before executing any of these commands from the CMD or Terminal make sure you are in the correct directory path. If using Eclipse or a 
similar IDE, these procedures may not be required.
### To Run Main Program:
From terminal: java -classpath ./bin main/Main
    
       This command will execute the Main.java class and output results according to the data gotten from the input files. If 
       the execution is successful, the names of the files generated will be displayed on the console.
       
       The execution of the program will be successful if the following conditions are satisfied:
       
          1. There is a directory under the name specified by the program ("inputFiles" by default).
         
               - In addition, there must be a dataFiles.txt file containing the names of the files to be tested.
          
          2. There is a directory under the name specified by the program ("outputFiles" by default) containing the
             output files of the program.
             
          3. The command is executed while in the correct directory path (.../p2_40354020_172).
          
       * For detailed information head to the in-code implementation *
From IDE: Run Main.java from the main package
### To Run Files Generator:
From terminal: java -classpath ./bin generators/FilesGeneratorMain

       This command will execute the FilesGeneratorMain.java class and output files according to specified parameters. 
       If the execution is sucessful, a message should be displayed on the console, describing the amount of files and
       and the amount of customers (integer values) in each file
       
        1. There is a directory under the name specified by the program ("inputFiles" by default).
          
        2. There is a directory under the name specified by the program ("outputFiles" by default).
             
        3. The command is executed while in the correct directory path (.../p2_40354020_172).
       
     * For detailed information head to the in-code implementation *
From IDE: Run filesGeneratorMain.java from the generators package
### To View Files:
From terminal: 
    
       Once located in the right directory path of the project (.../p2_40354020_172), head to the desired directory using 
       the following commands: 
            
            To view the inputFiles:
            
                cd inputFiles               (by default)
                
                cat data_i.txt              (where i is the number of the file to view, by default)
                
                ls                          (lists all the files in the directory)
                
            To view the outputFiles:
            
                cd outputFiles               (by default)
                
                cat data_i_OUT.txt           (where i is the number of the file to view, by default)
                
                ls                           (lists all the files in the directory)
                
      * For detailed information head to the in-code implementation *
From IDE: Open the desired directory, followed by the desired file.
## What the program does:
This software allows the user to simulate various scenarios in which customers wait to be served under different waiting policies.
The following, is a list of the simulated schemes:
### 1) Single Line Multiple Servers (SLMS):
This policy formats the customers into one waiting line and at least one service post (denoted as servers in-code). When a service
is finished (if any) then, the first customer in the waiting line will proceed to be served. Should more than one server be available,
the customer will proceed to the first service post available (the server with lowest index value)
### 2) Multiple Lines Multiple Servers (MLMS):
Customers formatted under this policy are placed into various waiting lines (one line per server). No transfers between lines occur 
under this policy. If a customer arrives, it will be allocated in the first line with the fewest number of people waiting.
### 3) Multiple Lines Multiple Servers and Balanced Line Lengths (MLMSBLL):
This policy formats the customers into multiple waiting lines and at least one service post. However, under this scheme, customers are allowed to transfer between lines but only, if and only if, that transfer is beneficial for the customer. For example, suppose there are 2 lines. On line 1, the last customer is customer #5. If, for an instance, the length on line 2 is 4, then the customer would not benefit from this change, since moving it to the second line would place it in the same position (4+1=5). However, if the line 2 has only 3 customer, then the last customer at line 1 would benefit from the transfer since it would place it in position 4. In addition, should more than one server be available, the customer will be transfered to the line closes to the its right.
### 4) Multiple Lines Multiple Servers and Balanced Line Lengths (MLMSBWT):
Similar to the waiting policy MLMS, the customers are placed in various waiting lines where no transfers can occur. However, under this policy, customers are allocated, after their arrival, on the line with the lowest waiting time, that is, the fastest moving line. Should more than one line be available, the transfer will occur to the line with lower index
## Understanding the code:
In order to understand the hierarchy of the classes, head to the "UML Kelvin Garcia CIIC4020-030.ucls" file or to the "README.pdf" file.
  ### Package generators
   #### Includes:
       FilesGeneratorMain.java (public) - generates input and output files according to specified parameters located in the
       parameters.txt file in the inputFiles directory. In addition, it will generate a file under the name "dataFiles.txt" containing
       the names of the files to be tested. The generated files may be one of three different types:
       
            1) Valid - will output the respective customers according to specifications
            
            2) Invalid - will output an invalid input of type String
            
            3) Non-existent - will output the name of the file in dataFiles.txt but will not create the file
            
        ** NOTE ** - This executions is done in order to test the files under different circumstances
  ### Package interfaces
   #### Includes:
       Deque.java (public) - interface of a deque implementation
       Queue.java (public) - interface of a queue implementation
  ### Package main
   #### Includes: 
       Main.java (public) - the main class to run the simulation. Prints in the output files the results of the simulation depending on 
                            the number of servers per policy and the type of file tested.
  ### Package simulationObjects
   #### Includes: 
       Customer.java (public) - represents the customers in the simulation. Before being served, each customer will have an arrival and
                                service time. After being served, each will have, aditionally, a departure time and a waiting time
       Monitor.java (public) - monitors the transfer of the MLMSBLL waiting policies, sorting according to the line lengths
       Server.java (public) - class used to manage the servers in the simulation
       WaitingLine.java (public) - contains the customers that have arrived before being sorted to the respective service line (if
                                   multiple lines existe) 
  ### Package inmplementation
   #### Includes:
       LinkedDeque.java (public) - a doubly linked list deque implementation
       SLLQueue.java (public) - a singly linked list queue implementation
  ### Package waitingPolicies
   #### Includes:
       MLMS.java (public) - Multiple Lines Multiple Servers waiting policy implementation
       MLMSBLL.java (public) - Multiple Lines Multiple Servers with Balanced Line Length waiting policy implementation
       MLMSBWT.java (public) - Multiple Lines Multiple Servers with Balanced Waiting Times waiting policy implementation
       SLMS.java (public) - Single Line Multiple Servers waiting policy implementation
  ### Directory inputFiles
   #### Includes:
       All inputFiles created by the FilesGeneratorMain.java class
       dataFiles.txt - contains the names of the files to be tested
       parameters.txt - contains the parameters of the file creation
  ### Directory outputFiles
   #### Includes: 
       The outputs of testing the files contained in dataFiles.txt
  ### UML-030.ucls 
   #### UML diagram with class hierarchy 
  #### To further understand how these strategies are implemented head to the in-code descriptions
