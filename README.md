# mars-robot
Mars Surveillance Robot repository.

This repository includes all the developed code to complete the coding backend test -2 for OCS.
It has been performed by Julián Reyes Romero. 


## Technologies
JAVA 8 + Spring Boot + Maven + Lombok + jUnit 5 and Mockito

#### Why Java 8 and Spring Boot?
It was clear to me to create the backen REST service using Spring Boot and Java 8 technologies for different reasons: 
* Spring Boot allows me to create a stand-alone spring application really quick.
* Spring Boot includes a embed Tomcat (so no need to deploy WAR files)
* I am really familiar with Java 8 sintax
    * Lambda expressions and the Streams API provides productivity improvements.

#### Why maven?
Maven it is my favourite project managemenent tool. As it is based on POM, it is really easy for me to include all the necessary dependencies in the main pom.xml file. 

#### Why Lombok
Lombok's @Data annotation in java classes allows to not to write all the getter and setter methods, as hash and equals methods. This provides more clarity while reading java 8 classes.

#### Why jUnit 5 and Mockito
To be honest, I've been working always with previous versions of jUnit. Given that spring boot version that I've used was configured with jUnit 5, it has been interesting to me to do some work with this version of the framework. 

Additionally, Mockito allow us to mock classes in our unit tests. It has been useful to mock robot class.

## Some design decissions

Given that the main methond will be managed directly by Spring boot, I have decided to implement a controller layer, represented by MarsRobotApplicationController class, which exposes an endpoint that will handles with POST request. 
```
http://localhost:8080/robot
```

The controller will pass the received request to a service layer, represented by MarsRobotService class, which is responsible of:
* to check if the terrain included in the request is a valid one
    * there is a terrain validator class, TerrainValidator, in charge of checking that all the materials of the terrain are accepted. If the material is not a good one, a MaterialDoesNotValidException will be throw.
* instances the Robot class with all the fields received in the request. I have decided that a robot instance be the owner of the terrain, list of visited cells, available battery, etc.
* it will makes use of a parse class, ParseRobotCommands, that will transform the list of commands from the requests, that are represented by their initials (F,B,E,W,E,S), to the associated command class. ParseRobotCommands will launch a CommandDoesNotValidException if the input list include a non accepted value.
    * I have implemented a command pattern for this. In this way, I will be able to run all the commands using Java 8 streams, avoiding to have a switch-case structure.

For those classes which implements Command class (command pattern), and that implies a new cell to be visit (I am talking about MoveForwardCommand and MoveBackwardsCommand), they run a validation of the next location to be visited. Class LocationValidator is in charge of this action, and it will check if the new cell to be visited is inside the terrain dimensions. If the new cell position is not inside the terrain dimensions, a LocationDoesNotValidException exception will be throw.

In order to calculate what is the new facing of the robot position when it has to turn left of right, I have given the responsability to MarsRobotFacingHandler class. Similarly, when it is necessary to get the coordinates of the cell to be visited when dealing with a forward or backwards command, I have given the responsability of taken that decision to MarsRobotPositionHandler.

All the coded exceptions will be handled by ErrorHandler class.

In the scenario of visiting a new cell in the terrain, but containing an 'Obstacle', I have implementd a command pattern again. MarsRobotBackoffStrategyHandler is in charge of it. 

## How to compile mars-robot
Once you have cloned this repository, the next command should be run in order to compile the code:
```
./mvnw clean package
```
During compilation time, all maven dependencies will be downloaded to your .m2 repository. 
Please to check that you have the proper settings.xml maven configuration.

It will generate a target folder with the next jar file:
```
./target/ocs-marsrobot-0.0.1-SNAPSHOT.jar
```

## mars-robot starting alternatives
After having compiled the code, there are several ways to launch the mars-robot application.

#### Start it with spring-boot
It will be necessary to run the next command from CLI, being in the root of the repositoy folder:
```
./mvnw spring-boot:run
```

#### Start the jar file
You will need to run the next command from CLI, being in the root of the repositoy folder:
```
java -jar ./target/ocs-marsrobot-0.0.1-SNAPSHOT.jar
```

In both cases, we will have the next output in our command line interface terminal:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-04-20 13:28:11.725  INFO 18892 --- [           main] com.ocs.marsrobot.MarsRobotApplication   : Starting MarsRobotApplication v0.0.1-SNAPSHOT on 29HW010382 with PID 18892 (C:\Users\TCS.jreyes\workspace\personal\ocs-mars-robot\target\ocs-marsrobot-0.0.1-SNAPSHOT.jar started by TCS.jreyes in C:\Users\TCS.jreyes\workspace\personal\ocs-mars-robot)
2020-04-20 13:28:11.728  INFO 18892 --- [           main] com.ocs.marsrobot.MarsRobotApplication   : No active profile set, falling back to default profiles: default
2020-04-20 13:28:13.737  INFO 18892 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-04-20 13:28:13.748  INFO 18892 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-04-20 13:28:13.748  INFO 18892 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2020-04-20 13:28:13.843  INFO 18892 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-04-20 13:28:13.843  INFO 18892 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2065 ms
2020-04-20 13:28:14.226  INFO 18892 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-04-20 13:28:14.416  INFO 18892 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 14 endpoint(s) beneath base path '/actuator'
2020-04-20 13:28:14.477  INFO 18892 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-04-20 13:28:14.480  INFO 18892 --- [           main] com.ocs.marsrobot.MarsRobotApplication   : Started MarsRobotApplication in 3.227 seconds (JVM running for 3.68)
```

## How to run mars-robot with an input json file

#### Running obs_test shell script
I have prepared a shell script that is available in the next path:
```
$MARS_ROBOT_CLONED_REPOSITORY_FOLDER/bin/obs_test
```

This scripts accepts 2 parameters: 
  1st parameter: input json which includes the request body to be sent to http://localhost:8080/robot
  2nd parameter: output json file where we want to store the response in json format.

#### Using postman collection
I've included a postman collection with 2 request:
  1st request: will allow us to send a request to mars-robot. It includes the proper header configuration and an input body example.
  2nd request: executes the command which allow us to stop mars-robot application.

The path of postman collection in the repository is:
```
$MARS_ROBOT_CLONED_REPOSITORY_FOLDER/postman/OCS_MARS_ROBOT.postman_collection.json
```

## How to stop mars-robot application in a controlled way
To stop the mars-robot application, we would need to run the next curl command:
```
curl -X POST http://localhost:8080/actuator/shutdown
```

This is possible because I have included spring-boot-starter-actuator in the pom.xml of the project. 
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
An additional configuration that I have done to allow mars-robot to accept POST request for finishing its execution, it is to add the next properties in application.properties file:
```
management.endpoint.shutdown.enabled=true
management.endpoint.info.enabled=true
management.endpoints.web.exposure.include=*
```

## Retrospective
As with all the developments, there are some things that I know that could be done better. This is a list of the things that I would like to improve if I have opportunity: 
* To increase the number of unit tests developed. I know that the percentage of coverage of the unit tests delivered could be improved. 
    * This will allow to do a better refactoring work following TDD technics.
* Creation of robot instance could be done following the factory pattern.
    * It will be useful if we have, for instance, the requirement of addapting the code to different versions of robots, with different features. 
* A logging framework could be included in order to write output traces to a log file.
