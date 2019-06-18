
This article explains the differences between the Spring Data JPA CrudRepository and JpaRepository interfaces. 
Both of them can be used as the parent interface for our repositories, but they are not the same.

<b>Background</b>

Before we jump into the differences, it’s good to know why are we using these interfaces in the first place. 

There are two reasons for that:

a)Extending these interfaces allows Spring to find your repository interfaces and create proxy objects for them, that you can inject later on into your beans.

b)It provides you with methods that allow you to perform some common operations without the need to declare these methods yourself.

<b>Differences</b>
  
When talking about the differences of CrudRepository and JpaRepository, it is a good idea to take a third interface into account: the PagingAndSortingRepository. This is because these interfaces the following inheritance hierarchy between them:


 PagingAndSortingRepository extends CrudRepository
 <br/>
 JpaRepository extends PagingAndSortingRepository


The CrudRepository interface provides methods for CRUD operations, so it allows you to create, read, update and delete records without having to define your own methods. 

The PagingAndSortingRepository provides additional methods to retrieve entities using pagination and sorting. 

Finally the JpaRepository add some more functionality that is specific to JPA.

Generally the best idea is to use CrudRepository or PagingAndSortingRepository depending on whether you need sorting and paging or not. The JpaRepository should be avoided if possible, because it ties you repositories to the JPA persistence technology, and in most cases you probably wouldn’t even use the extra methods provided by it.

______________________________________________________________________________________________________________________________________


JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.

Their main functions are:

CrudRepository mainly provides CRUD functions.

PagingAndSortingRepository provides methods to do pagination and sorting records.

JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.

Because of the inheritance mentioned above, JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. 
So if you don't need the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.

Reference:
<pre>
Properies ->      https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
JPA Methods ->    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/  search : table 3
JpaRepository ->  https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
Sort Properties-> https://stackoverflow.com/questions/33018127/spring-data-rest-sort-by-multiple-properties
</pre>

