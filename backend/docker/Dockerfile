FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.2-6

VOLUME /tmp

EXPOSE 8080
USER root
ENV TZ='America/Sao_Paulo'
RUN unlink /etc/localtime && ln -s /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime
ARG JAR_FILE="target/backend.jar"

ADD ${JAR_FILE} app.jar
# Usuario default do container
USER jboss

# run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","app.jar"]
