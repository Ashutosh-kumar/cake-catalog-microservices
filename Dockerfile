FROM openjdk:11
EXPOSE 8080
ADD target/cake-catalog-springboot-service.jar cake-catalog-springboot-service.jar
ENTRYPOINT ["java" , "jar" , "/cake-catalog-springboot-service.jar"]