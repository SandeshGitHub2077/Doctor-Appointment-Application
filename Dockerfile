FROM openjdk:8
#base image version

ADD target/BookMyDoctorServer-0.0.1-SNAPSHOT.jar server.jar

EXPOSE 8761

#execute jar file
ENTRYPOINT ["java", "-jar", "server.jar"]


