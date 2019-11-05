FROM java:8-jdk-alpine

COPY ./target/gateway-zuul-1.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch gateway-zuul-1.0.jar'

ENTRYPOINT ["java", "-jar", "gateway-zuul-1.0.jar"]
