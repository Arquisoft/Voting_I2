FROM maven

COPY . /usr/src

WORKDIR /usr/src

RUN apt-get update && \
    apt-get install -y mysql-client

RUN mvn package -DskipTests

CMD tail -f /dev/null