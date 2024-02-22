FROM eclipse-temurin:17
LABEL authors="shalini cherukuri"
WORKDIR /home
COPY ./target/primes-service-0.0.1-SNAPSHOT.jar prime-service.jar
ENTRYPOINT ["java", "-jar","prime-service.jar"]