# Animal Pictures Service Deployment Guide

### Overview

This guide explains how to set up and run the Animal Pictures Service locally or inside a Docker container.
 You will also learn how to access the client web application to view randomly generated animal pictures.

------



### Prerequisites

| Component      | Verison                 |
| -------------- | ----------------------- |
| Java JDK 17+   | Temurin                 |
| Maven          | 3.8+                    |
| Docker Desktop | Latest                  |
| Postman        | Latest                  |
| Web Browser    | Chrome, Firefox, Safari |

------



### Application Architecture

```
[ Browser Client ]  --->  [ Spring Boot REST API ]  ---> [ In-Memory H2 Database ]

```

* Frontend (`index.html`) requests API endpoints.
* Backend saves and retrieves animal picture data.
* All services can be run natively or inside a Docker container.

------



### Running the Application

To run the application directly on your machine:

1. Clone the repository:

```bash
git clone https://github.com/YOUR-USERNAME/animalpictures.git
cd animalpictures
```

2. Start the Spring Boot Server:

```bash
./mvnw spring-boot:run
```

3. Open your browser and navigate to:

```bash
http://localhost:8080/
```

4. Use the dropdown menu to select an animal and fetch a random picture.

------

### Building and Running with Docker

**Important:** Ensure Docker Desktop is running before building the container

1. Build Docker image:

```bash
docker build -t animalpictures .
```

2. Run Docker container:

```bash
docker run -p 8080:8080 animalpictures
```

3. Access the client web at:

```bash
http://localhost:8080/
```



------



### Rest API Reference

| Method | Endpoint                              | Description                                      |
| ------ | ------------------------------------- | ------------------------------------------------ |
| `POST` | `/api/animals/save?type=bear&count=1` | Saves a new animal picture                       |
| `GET`  | `/api/animals/last?type=bear`         | Retrieves the most recently saved animal picture |

------



#### Testing

The application includes an automated test to verify the `/save` endpoint is available.

Run the teste suite using:

```bash
./mvnw test
```

##### Expected Result:

* Test passes with HTTP 200 OK
* Build result shows `BUILD SUCCESS`

------

#### 

### Conclusion

You have successfully deployed and run the Animal Pictures Service, both locally and within a containerized environment.
 Feel free to build on this base project to explore advanced backend and frontend integrations.
