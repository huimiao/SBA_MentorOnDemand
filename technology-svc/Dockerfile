FROM java:8-jdk-alpine

COPY ./target/technology-svc-1.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch technology-svc-1.0.jar'

ENTRYPOINT ["java", "-jar", "technology-svc-1.0.jar"]
