#!/usr/bin/env bash


#This script will create a docker image from a dockerfile, push it to dockerhub.com  and run it
docker -v

export username="matiasagnolin"
export password="tigrecorazon"
export email="matiasagnolin@gmail.com"
export docker_file_name="Dockerfile"
export repo="continuosintegration"
export image_name="jenkins_image"
export docker_path="/home/projects/amarisfutbol/Jenkins"
export container_name="Jenkins_container"

#git checkout "$docker_path/$docker_file_name"

echo "TRYING TO STOP JENKINS CONTAINER->"
docker stop $container_name

echo "TRYING TO DELETE THE OLD IMAGE->"
docker rmi $image_name

echo "TRYING TO DELETE TERMINATED CONTAINERS->"
docker rm -f $(docker ps -a -q)

#To build this image this script must be in the same directory
docker build -t $image_name .

echo "----------DOCKER IMAGES-------------"

docker images

echo "------------------------------------"

docker login --username $username --password $password

docker tag $image_name $username/$image_name:latest

docker push $username/$image_name

docker run -d -it -p 8080:8080 --name $container_name $my_image

echo "----------SCRIPT FINISHED-------------"








