FROM openjdk:17
EXPOSE 8001
ADD target/spring-boot-crud.jar spring-boot-crud.jar
ENTRYPOINT ["java","-jar","/spring-boot-crud.jar"]