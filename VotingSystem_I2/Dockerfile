FROM maven

COPY . /usr/src

WORKDIR /usr/src

RUN apt-get update && \
    apt-get install -y mysql-client

CMD mvn spring-boot:run