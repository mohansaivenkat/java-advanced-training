FROM eclipse-temurin:17.0.18_8-jdk

LABEL "org.opencontainers.image.authors"="dockerprac"

# Removed the leading slash before target
COPY target/docker-practice-0.0.1-SNAPSHOT.jar app.jar

# Kept your fixed ENTRYPOINT space
ENTRYPOINT ["java", "-jar", "app.jar"]