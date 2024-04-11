FROM openjdk:17-slim as build

LABEL maintainer="Matorin Fedor <f.matorin@mail.ru>"

ARG JAR_FILE

COPY /target/service-discovery-0.0.1.jar app.jar

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)


FROM openjdk:17-slim

VOLUME /tmp

ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","org.example.servicediscovery.ServiceDiscoveryApplication"]