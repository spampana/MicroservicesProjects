Refer to https://helpezee.wordpress.com/2019/08/03/event-sourcing-and-cqrs-with-axon-and-spring-boot/ for test scenario's and application explanation.

we will perform Event Sourcing and CQRS in the same application.
We will be using Spring Boot for our normal application logic.
For Event Sourcing and CQRS we will be using Axon Framework.
Since we are using the same application for both Event Sourcing and CQRS, we will be using RDBMS (in this case an in-memory H2 database) as both a event store and query store.
To connect to the database, we will leverage Spring Data JPA.