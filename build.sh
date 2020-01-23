git pull
mvn clean
mvn package -DskipTests
docker image rm -f back
docker container rm -f back
docker build -t back .
docker run -e SPRING_DB_PASSWORD -e SPRING_DB_URL -e SPRING_DB_USERNAME -p 9090:9090 -d --name back back 
