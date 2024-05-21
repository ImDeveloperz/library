FROM openjdk:21-slim-bullseye
COPY . .

COPY /target/bibliotheque-0.0.1-SNAPSHOT.jar bibliotheque.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","bibliotheque.jar"]