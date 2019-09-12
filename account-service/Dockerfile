FROM openjdk:11.0.3
VOLUME /tmp
COPY target/account-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms64m", "-Xmx128m", "-jar", "/app.jar"]