FROM openjdk:21-jdk-slim
WORKDIR /app

COPY . ./

RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
RUN cp target/*.jar app.jar

EXPOSE 10002

CMD ["java","-jar","app.jar"]
