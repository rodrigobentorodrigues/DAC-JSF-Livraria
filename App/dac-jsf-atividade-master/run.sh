sudo docker stop web
sudo docker rm web
sudo docker rmi atividade/web
mvn clean install
sudo docker build -t atividade/web .
sudo docker run -p 8081:8080 -d --name web --link banco:host-banco atividade/web

