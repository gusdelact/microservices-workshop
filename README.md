
Project which helps to explain different aspects regarding microservices architecture according to Richardson's pattern language for microservices. The purpose is to show concepts of the microservices architecture through a sequence of stages according to the life cycle of microservices proposed on the book "Spring Microservices in Action". Every stage has its own Git branch in order to focus in specific concepts such as deployment, communication among services, cross cutting concerns, resiliency, etc.



# Branches

Use git checkout to change among branches.

## v1.x. Assembly

Standalone spring-boot microservices. Intented to show the deployment in OpenShift, ECS and excecuting simple CI/CD pipelines. 

## v2.x. Bootstraping

Microservices' self-service registration into discovery service (Eureka). External configuration via Spring Config Server or AWS Secure Secrets Manager.

## v3.x. Discovery

Service discovery (Eureka). Making services more resilient implementing circuit breakers (Hystrix). Implementing security mechanisms. Event-driven architecture with asynchronous messaging.

## v4.x. Monitoring

Security mechanisms (oauth, authentication). Microservices exposure through via REST API. Consuming microservices from an angular-based single page application.

## v5.x. UI

Consuming services through a single-page application (Angular-based application). Routing microservices from the outside world through and API (Zuul)

## Cloning repo from codecommit

Follow the public guide provided by AWS to configure your local machine.

https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-ssh-unixes.html 

# !IMPORTANT Some rules
* Keep master branch only with the README file
* Update README file on master branch and merge into the other branches
* Do not merge on master branch
* Branch from branches and keep the sequence. The idea is to keep the evolution of the examples


# Contributors

* Gustavo de la Cruz (awsgus@)
* Ricardo Casteñeda (awsric@)