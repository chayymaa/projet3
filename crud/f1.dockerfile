FROM openjdk:11-jre-slim
COPY target/tractor-app.jar tractor-app.jar
CMD ["java", "-jar", "tractor-app.jar"]
