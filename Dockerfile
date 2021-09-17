FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8200

ENV DATABASE_CONNECTION_URL="jdbc:mysql://db:3306/investimentodb"
ENV EUREKA_CONNECTION_URL="http://eureka:8761"

COPY target/investimento.jar /app/investimento.jar

ENTRYPOINT ["java", "-jar", "investimento.jar"]
