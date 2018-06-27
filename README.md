# VideoConference 

Web application for University of Technology in Gliwice for streaming video conferences. 
Project was made using Spring Boot 2.0 and Angular 6. The server is created in accordance with the Rest API architecture. 
Client was made using Angular 6 Framework and bootstrap.
Client is sending requests to Rest API server in order to get/add datas about streams.

[[http://i65.tinypic.com/2ztkped.jpg]]

##Build environment:
* install node version 8.2.1
* install npm version 5.8.0
* install gradle version > 4.2
* npm install -g @angular/cli

##Run application
### Spring Boot server side:
In main project directory you have to run this command:
* `./gradlew bootRun`

### Angular 6 Frontend application:
Run Angular application with commands: 
* `cd src/main/webapp`
* `ng serve`  

### Deploy Spring Boot application
Deploy Rest API as jar/war file
* `./gradlew build`
* `cd build/libs` and run server with command `java -jar "name of built package"`

### Deploy Angular application
Deploy Angular app to java script
* `cd src/main/webapp`
* `ng build --prod`