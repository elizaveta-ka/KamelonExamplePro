FROM openjdk:18
WORKDIR /build
ADD ./target/KamelonExamplePro-0.0.1-SNAPSHOT.jar ./test.jar
#COPY target/KamelonExamplePro-0.0.1-SNAPSHOT.jar /usr/app/
EXPOSE 8080
CMD java -jar test.jar