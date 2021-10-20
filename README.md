#Demo Application for manage GOT Battles Using Spring

## Tools & Library used

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Spring Boot 2.1.3]
- [Apache Commons]
- [Spring Data JPA]
- [MySQL Connector]

## Running the application locally

1. Build the project using
  `mvn clean install`
2. Run using 
  `mvn spring-boot:run`
3. Base url of the application is - localhost:8080/got/api/v1
4. To Upload csv file url -  {{baseUrl}}/importCsvData - POST
5. To Fetch the battle list url - {{baseUrl}}/getBattlesList - GET
6. To Count the record url - {{baseUrl}}/getBattlesCount - GET
7. To fetch the details of a Battle by number url - {{baseUrl}}/getBattleByNumber - GET
8. To fetch the Place List url - {{baseUrl}}/placesList - GET


## Deploying the application to Tomcat Server

1. Build the project using
  `mvn clean install`
2. Rename the war/jar file to 'got'
3. Deploy that file to server & restart the server.
