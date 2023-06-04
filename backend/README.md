# Online Pet Store
## About
Online pet store is a Rest Api project with basic CRUD (create, read, update, delete). The design pattern DDD has been used.\
For this project I used separate docker containers. One of them is for the MySql and the other is for the Project. \
Also I create docker network to connect with each other.

## Technologies
- Java 11,
- Spring boot,
- Spring security,
- Spring data JPA,
- MySql database,
- Maven,
- Docker,
- Lombok;

## Features
- Swagger
- Rest Api,
- CRUD,
- Domain Driven Design (DDD),
- Docker infrastructure;

## Setup
### Without docker
Go to application.properties and change jdbc link from <b>MySQL-dock:3306</b> to <b>localhost:3306</b> \
Also you have to create same database name, user and password like in project or just change settings for your database. \
After this you are ready to start project and you can try controllers on page: localhost:3306/swagger-ui.html

### With docker
On Windows you have to install WSL (ubuntu) and create docker images for project. \
Dockerfile is ready in main project folder.

### With docker via docker network
Instruction for this method is the same as above but you have to create seperate docker images for MySQL and project. \
Then create docker network and run both dockers. First docker with MySQL image then docker with project because project needs ready-made MySQL docker network.
