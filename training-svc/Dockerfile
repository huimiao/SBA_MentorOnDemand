FROM java:8-jdk-alpine

COPY ./target/training-svc-1.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch training-svc-1.0.jar'

ENTRYPOINT ["java", "-jar", "training-svc-1.0.jar"]
