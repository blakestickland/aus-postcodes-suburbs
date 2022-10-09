# aus-postcodes-suburbs project

API created in Java using Spring Boot that allows clients to search for Australian postcodes and suburbs. Clients with the admin login details can also add new suburb and postcode combinations.

## MVP:

* An API that allows clients to retrieve suburb information by postcode.
* An API that allows clients to retrieve a postcode by providing a suburb name.
* A secured API to add new suburb and postcode combinations.
* Some form of persistence.

## Endpoints
***
  * "/"
    * GET   Health Check    returns “Hello World!”          200 OK
***
  * "/aupostcodes/search?postcode=[ENTER POSTCODE]"
    * GET   Postcode Search returns JSON array of results   200 OK
***
  * "/aupostcodes/search?suburb=[ENTER SUBURB]"
    * GET   Suburb Search   returns JSON array of results   200 OK
***
  * "/aupostcodes/admin"
    * GET   All records     requires a sign in              200 OK
***
  * "/aupostcodes/admin/[ENTER ID]"
    * GET   ID Search       requires a sign in              200 OK or 500 not ID found
***
  * "/aupostcodes/admin/create"
    * POST  Create postcode/suburb   requires a body/sign-in 201 created
***
### Example JSON Body for to create new database entry: 

```
    {
        “suburb’: “New Brisbane”,
        “postcode”: “8999”
    } 
```
        or 
```
    {
        “suburb’: “New Brisbane”,
        “postcode”: “4999”,
        “state”: “QLD”
    } 
```

NOTE: submitting just the required fields ("suburb" and "postcode") can be done multiple times as there are examples of current postcodes with the same suburb and postcode, but different State locations. E.g.: Williamsdale, 2620, NSW & ACT
            
NOTE: you cannot submit duplicate entries if the "suburb", postcode" and "state" are identical however. At the moment, this returns a 500 Internal Server Error. For each database entry, the combination of "suburb", postcode" and "state" is unique.

## Admin login details:

  * To use the protected admin endpoints, users can login with: 
        username: admin
        password: 49ef7645-7aab-4ad8-b85b-a1c77de65c93

## Build and Deploy

* Deploy the the built project by uploading the jar file in the target directory (target/postcodesau-0.0.1-SNAPSHOT.jar).
* Or build a version of the code by running: 
  
```
    ./mvnw clean install
```

or 

```
    ./mvnw clean install -DskipTests
```

* An example of the project is running at:
  * http://aupostcodessuburbs-env.eba-a548885m.ap-southeast-2.elasticbeanstalk.com/

* Environment Properties:
  * SERVER_PORT: 5000
  * SPRING_DATASOURCE_URL: jdbc:mysql://awseb-e-vk9q2v9ans-stack-awsebrdsdatabase-coig5kddqcik.ck5klfvmlf0r.ap-southeast-2.rds.amazonaws.com:3306/ebdb
  * SPRING_DATASOURCE_USERNAME: root
  * SPRING_DATASOURCE_PASSWORD: password
  * SPRING_JPA_DATASOURCE_PLATFORM: org.hibernate.dialect.MySQL5Dialect
  * SPRING_JPA_HIBERNATE_DDL_AUTO: none


## Future development
* Add more error handling. Provide clear and descriptive messages to users.
* Change how the data set seeds when launching the application. Current implementation caused an issue with Hibernate's auto increment for the ID so added code to workaround.
* Increase the number of tests.
* Change to a token based Admin login such as JWT rather than the Spring Security session based method implemented. 
* In order to get the POST request to work, CSRF has been diabled. It would be better to not disable CSRF.  

## Contributor
* Blake Stickland https://github.com/blakestickland