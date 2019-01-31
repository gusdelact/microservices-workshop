
Project which helps to explain different aspects regarding microservices architecture according to Richardson's pattern language for microservices. The idea is to show concepts of the architecture through a sequence of steps. Every step has its own Git branch in order to focus in concepts such as deployment, communication among services, cross cutting concerns, resiliency, etc.

# Branches

Use git checkout to change among branches.

## v1.x

Standalone spring-boot microservice. Intented to show the deployment in OpenShift, ECS and excecuting simple CI/CD pipelines

## v2.x 

Interaction between microservicio-base and microservicio-dummy. Self-registration and discovery with Eureka.

## v3.x

Circuit breaker, tracing and integration with data repositories.

## v4.x

Security mechanisms (oauth, authentication). Microservices exposure through via REST API. Consuming microservices from an angular-based single page application.

## v5.x

Asynchronous interaction among services utilizing messaging.


## Cloning repo from codecommit

Follow the public guide provided by AWS to configure your local machine.

https://docs.aws.amazon.com/codecommit/latest/userguide/setting-up-ssh-unixes.html 



# Contributors

* Gustavo de la Cruz (awsgus@)
* Ricardo Casteñeda (awsric@)