FROM java:8-jre

# copy jar file to docker file system
ADD ./target/company-0.0.1-SNAPSHOT.jar /usr/app/company-0.0.1-SNAPSHOT.jar

# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "company-0.0.1-SNAPSHOT.jar"]
EXPOSE 8091
