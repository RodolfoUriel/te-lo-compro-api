FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY "./target/telocompro-0.0.1-SNAPSHOT.jar" ./

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "telocompro-0.0.1-SNAPSHOT.jar" ]