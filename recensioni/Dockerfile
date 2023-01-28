FROM openjdk:11-jdk

ADD build/libs/recensioni.jar recensioni.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Xmx128m", "-Xms128m", "-jar", "recensioni.jar" ]