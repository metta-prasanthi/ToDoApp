# FROM maven:3-jdk-8-slim

# COPY ./target/hw_05_15-0.0.1-SNAPSHOT.jar /usr/app/

# WORKDIR /usr/app

# RUN sh -c 'touch todo-0.0.1-SNAPSHOT.jar'

# ENTRYPOINT ["java","-jar","todo-0.0.1-SNAPSHOT.jar"]


FROM openjdk:8-jdk-alpine

VOLUME /tmp

#ENV SPRING_PROFILES_ACTIVE="local"

# ENV MYSQL_DB_HOST="mysql_db"
# ENV MYSQL_DB_NAME="test"
# ENV MYSQL_DB_USER="root"
# ENV MYSQL_DB_PASS="root"

# ENV REDIS_DB_HOST="redis_db"
# ENV REDIS_DB_PORT="6379"
# ENV REDIS_DB_PASS="root"

# RUN mkdir /todo-services
# WORKDIR /todo-services

# COPY . /todo-services

# RUN cd /todo-services

COPY ./target/todo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch todo-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","todo-0.0.1-SNAPSHOT.jar"]
