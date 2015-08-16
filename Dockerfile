FROM java:8
MAINTAINER stefanovic.darko@gmail.com
EXPOSE 8080
ADD build/libs/hjug-springboot-web-0.1.0.jar /hjug-springboot-web-0.1.0.jar
CMD java -jar -Dspring.profiles.active=$ACTIVE_PROFILE /hjug-springboot-web-0.1.0.jar

