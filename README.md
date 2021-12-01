# RabbitMQ with SpringBoot

## RabbitMQ setup
RabbitMQ setup run inside a docker container through a docker-compose file:
 ```
services:
    rabbitmq:
        image: rabbitmq:3-management-alpine
        container_name: rabbitmq
        ports:
            - "5672:5672"
            - "15672:15672"
        volumes: 
            - "./dados:/var/lib/rabbitmq/"
        environment:
            - DEFAULT_USER=admin
            - DEFAULT_PASS=admin
```

In the same directory that contains the docker-compose file, run:
```
docker-compose up -d
```
You can now acess RabbitMQ Management on **localhost:15672**

## Producer

The producer project contains two ways of RabbitMQ configuration.
<br>
The first can be found in RabbitMQConnection.java class.
<br>
The second can be found in rabbitmq.config classes.



            
