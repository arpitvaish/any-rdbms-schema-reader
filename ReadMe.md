# Getting Started

##Installation instruction
1. Extract the zip content in a suitable directory on you machine
2. Using any IDE (Eclipse/Intellij) import the project as existing Maven Project into it
3. Install the maven project by command mvn clean install on cmd of same directory
4. Right click on file SchemaReaderApplication.java -> Run as Java Application
5. Open any browser (Preferrably Google chrome), go to URL : http://localhost:8080/swagger-ui.html
   
   5.1 Click on Controller ->  Try it out -> Fill the required details and click execute
   5.2 Out will be shown on the lower box
   
## Adding a new DB Type (RDMS only)
1. Go to file DBType.java :   Add the DB information as other  system. Make sure URL is add as "URL", port as "PORT" and Schema Name as DBName



