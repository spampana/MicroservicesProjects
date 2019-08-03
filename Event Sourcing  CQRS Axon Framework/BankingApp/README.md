Refer to https://helpezee.wordpress.com/2019/08/03/event-sourcing-and-cqrs-with-axon-and-spring-boot/ for test scenario's and application explanation.
<br/>
<br/>
<br/>
we will perform Event Sourcing and CQRS in the same application.
<br/>
We will be using Spring Boot for our normal application logic.
<br/>
For Event Sourcing and CQRS we will be using Axon Framework.
<br/>
Since we are using the same application for both Event Sourcing and CQRS, we will be using RDBMS (in this case an in-memory H2 database) as both a event store and query store.
<br/>
To connect to the database, we will leverage Spring Data JPA.
<br/>
