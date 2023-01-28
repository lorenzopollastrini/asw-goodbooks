FROM openjdk:11-jdk

ADD build/libs/recensioni-seguite.jar recensioni-seguite.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Xmx128m", "-Xms128m", "-jar", "recensioni-seguite.jar" ]