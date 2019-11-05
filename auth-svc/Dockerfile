FROM java:8-jdk-alpine

COPY ./target/auth-svc-1.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch auth-svc-1.0.jar'

ENTRYPOINT ["java", "-jar", "auth-svc-1.0.jar"]
