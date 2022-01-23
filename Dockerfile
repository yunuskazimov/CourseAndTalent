FROM openjdk:17-slim-buster

COPY build/libs/CourseAndTalant-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar CourseAndTalant-0.0.1-SNAPSHOT.jar