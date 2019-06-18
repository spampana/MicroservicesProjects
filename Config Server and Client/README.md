Config Server
=============
1) Annotate with @EnableConfigServer

2) spring.cloud.config.server.git.uri=https://github.com/spampana/conf 
   should be defined in application.properties file which is pointing to the git repository path 
   where property files are kept in the format like applicationName.properties

Config Client
=============

1) Annotate with @EnableConfigClient

2) Annotate with @RefreshScope to be defined to support the auto relaod of properties without server restart
<pre>
   Note:
   Rename application.properties to bootstrap.properties
   We should make a Post call to http://localhost:8080/actuator/refresh inorder to get the latest properties from git
   Make sure that spring.application.name is matching with property file name define in the git
</pre>

3) Define the  below property to tell the config server path to client
   spring.cloud.config.uri=http://localhost:8081

4) spring.cloud.config.fail-fast=true tells spring to throw exception if property file is not found

5) management.security.enabled=false  to disable security

6) management.endpoints.web.exposure.include=* to expose all acuator Urls

<pre>

{
   "_links":{
      "self":{
         "href":"http://localhost:8080/actuator",
         "templated":false
      },
      "auditevents":{
         "href":"http://localhost:8080/actuator/auditevents",
         "templated":false
      },
      "beans":{
         "href":"http://localhost:8080/actuator/beans",
         "templated":false
      },
      "caches-cache":{
         "href":"http://localhost:8080/actuator/caches/{cache}",
         "templated":true
      },
      "caches":{
         "href":"http://localhost:8080/actuator/caches",
         "templated":false
      },
      "health":{
         "href":"http://localhost:8080/actuator/health",
         "templated":false
      },
      "health-component":{
         "href":"http://localhost:8080/actuator/health/{component}",
         "templated":true
      },
      "health-component-instance":{
         "href":"http://localhost:8080/actuator/health/{component}/{instance}",
         "templated":true
      },
      "conditions":{
         "href":"http://localhost:8080/actuator/conditions",
         "templated":false
      },
      "configprops":{
         "href":"http://localhost:8080/actuator/configprops",
         "templated":false
      },
      "env":{
         "href":"http://localhost:8080/actuator/env",
         "templated":false
      },
      "env-toMatch":{
         "href":"http://localhost:8080/actuator/env/{toMatch}",
         "templated":true
      },
      "info":{
         "href":"http://localhost:8080/actuator/info",
         "templated":false
      },
      "loggers":{
         "href":"http://localhost:8080/actuator/loggers",
         "templated":false
      },
      "loggers-name":{
         "href":"http://localhost:8080/actuator/loggers/{name}",
         "templated":true
      },
      "heapdump":{
         "href":"http://localhost:8080/actuator/heapdump",
         "templated":false
      },
      "threaddump":{
         "href":"http://localhost:8080/actuator/threaddump",
         "templated":false
      },
      "metrics-requiredMetricName":{
         "href":"http://localhost:8080/actuator/metrics/{requiredMetricName}",
         "templated":true
      },
      "metrics":{
         "href":"http://localhost:8080/actuator/metrics",
         "templated":false
      },
      "scheduledtasks":{
         "href":"http://localhost:8080/actuator/scheduledtasks",
         "templated":false
      },
      "httptrace":{
         "href":"http://localhost:8080/actuator/httptrace",
         "templated":false
      },
      "mappings":{
         "href":"http://localhost:8080/actuator/mappings",
         "templated":false
      },
      "refresh":{
         "href":"http://localhost:8080/actuator/refresh",
         "templated":false
      },
      "features":{
         "href":"http://localhost:8080/actuator/features",
         "templated":false
      }
   }
}

</pre>


