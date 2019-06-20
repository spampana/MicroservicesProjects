<b>Zuul, among many other things, fetches from Eureka service locations and does server-side load balancing.</b>

When Zuul receives a request, it picks up one of the physical locations available and forwards requests to the actual service instance. The whole process of caching the location of the service instances and forwarding the request to the actual location is provided out of the box with no additional configurations needed.

<b>Internally, Zuul uses Netflix Ribbon to look up for all instances of the service from the service discovery (Eureka Server).</b>
