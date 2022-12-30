FROM openjdk:11-jdk

ADD build/libs/connessioni.jar connessioni.jar

ENTRYPOINT [ "java", "-Xmx128m", "-Xms128m", "-jar", "connessioni.jar" ]