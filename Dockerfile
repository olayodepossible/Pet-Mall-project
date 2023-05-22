FROM openjdk:15.0.1-oracle

#RUN addgroup -S spring && adduser -S spring -G spring

#USER spring:spring

ARG DEPENDENCY=target/dependency

COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","petmall.PetMallApplication"]
