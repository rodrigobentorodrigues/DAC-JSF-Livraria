sudo docker stop banco
sudo docker rm banco
sudo docker rmi atividade/banco
sudo docker build -t atividade/banco .
sudo docker run -p 5433:5432 -d --name banco atividade/banco
