sudo docker stop banco
sudo docker rm banco
sudo docker rmi rc/banco
sudo docker build -t rc/banco .
sudo docker run -p 5433:5432 -d --name banco rc/banco
