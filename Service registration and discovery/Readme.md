<b>What is Netflix Eureka Server and Clients? </b>

As we know these days, there is a lot of momentum around Microservices. The transition from Monolithic to Microservice based architecture gives many benefits for future in terms of maintainability, scalability, high availability etc. However at the same time, there are many challenges also while doing this migration. One of them is to maintain individual Microservices addresses. This task can be hugely complex – depending on number of services and their dynamic nature. If whole infrastructure is distributed and there is some replication as well, then maintaining this service addresses becomes harder.

To solve this, in the distributed computing are there is a concept called ‘Service registration and discovery’ where one dedicated server is responsible to maintain the registry of all the Microservice that has been deployed and removed. This will act like a phone book of all other applications/microservices.

Think of it as a lookup service where microservices (clients) can register themselves and discover other registered microservices. When a client microservice registers with Eureka it provides metadata such as host, port, and health indicator thus allowing for other microservices to discover it. The discovery server expects a regular heartbeat message from each microservice instance. If an instance begins to consistently fail to send a heartbeat, the discovery server will remove the instance from his registry. This way we will have a very stable ecosystem of Microservices collaborating among each other, and on top of it we don’t have to manually maintain address of other Microservice, which is a next to impossible task if the scale up/down is very frequent, on demand and we use virtual host to host the services specially in the cloud environment.


<b>Eureka Naming Server</b> – This microservice will provide the service registry and discovery server.

<b>EurekaServiceRegistryAndDiscovery Microservice </b> – Which will give some functionality based on Employee entity. It will be a rest based service and most importantly it will be a eureka client service, which will talk with eureka service to register itself in the service registry.

<b>EurekaServiceDiscovery Microservice </b> – Same type as of EurekaServiceRegistryAndDiscovery service – only added feature is that it will invoke Employee service with service look up mechanism. We will not use absolute URL of Employee service to interact with that service.
