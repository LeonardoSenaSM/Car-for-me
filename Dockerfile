FROM eclipse-temurin:17
LABEL maintainer="leomagridf@gmail.com"

WORKDIR /app

COPY target/CarForMe-0.0.1-SNAPSHOT.jar /app/car4me.jar

ENTRYPOINT ["java", "-jar", "car4me.jar"]