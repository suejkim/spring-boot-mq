# RabbitMQ

### 정의

### 설치
- Docker로 RabbitMQ 설치
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```
- management plugin: http://container-ip:15672
- username/pwd: guest/guest


---
> https://hub.docker.com/_/rabbitmq
> https://www.rabbitmq.com/getstarted.html
> https://www.cloudamqp.com/blog/part1-rabbitmq-for-beginners-what-is-rabbitmq.html
> https://thepracticaldeveloper.com/produce-and-consume-json-messages-with-spring-boot-amqp/
> https://jonnung.dev/rabbitmq/2019/02/06/about-amqp-implementtation-of-rabbitmq/
> https://www.baeldung.com/spring-scheduled-tasks