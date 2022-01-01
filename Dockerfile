FROM openjdk:11
EXPOSE 8088
ADD target/cake-catalog-springboot-service.jar cake-catalog-springboot-service.jar
ENTRYPOINT ["java" , "-jar" , "/cake-catalog-springboot-service.jar"]