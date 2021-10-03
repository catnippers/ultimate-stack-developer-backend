<img alt="Catnippers Social Club" src="https://github.com/catnippers/catnippers-landing-page/blob/evan/src/images/catnippers_logotype-01%201.png" />

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/ca2ee88e52a643fab2ba892a1cb73082)](https://www.codacy.com/gh/catnippers/ultimate-stack-developer-backend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=catnippers/ultimate-stack-developer-backend&amp;utm_campaign=Badge_Grade)

# Ultimate Stack Developer (Backend)
### Created by Tomasz Buga

GitHub: https://github.com/n4bik

LinkedIn: https://www.linkedin.com/in/tomasz-buga-79933886/

mail: `kontakt@tomaszbuga.pl`

## Project Overview
Live Demo: https://ultimatestackdeveloper.netlify.com

**Ultimate Stack Developer** is an application for managing micro-scale blog about `whatever you can imagine!`

### Tech Stack
Backend part is based on:
- Dedicated Database server of your choice (for the development
  I'm using `Linux Ubuntu Server` with `PostgreSQL` setup within `Docker`'s container and exposed to the local (home) network)

- `Java 8` with `Spring Boot`

- `GraphQL` for managing API communication between the frontend and the backend

## Key Files Description
`Dockerfile` - this file enables Docker Hub to properly dockerize* the app

`pom.xml` - this file contains all the dependencies that are being used by the application (and basically everything for the building/testing/deploying automation with Java)

* *to dockerize* - to set up application on the so-called `container`, therefore being able to deploy it, without a
  hustle on any docker-engine based environment (to smooth this process a little more, it's common to deploy
  multiple containers together using the docker-compose library)

## API & CORS (Cross-Origin-Resource-Sharing) Handling

Backend of the UltimateStackDeveloper app uses the CORS to secure API requests made by browsers and narrows it down
to `https://ultimatestackdevleoper.netlify.app` by default (as it is the production server address).

### CORS Security Toggle
Modify this line in order to remove/add CORS security `src/main/java/pl/tomaszbuga/ultimatestackdeveloper/config/JwtSecurityConfig.java:56` (`corsConfigurationSource()`)

## Upcoming fixes (a.k.a. To-Do List)
1. Create User handling mechanism (registration/login for the client-side of the app) (*TO DO AFTER FIXING THE FRONTEND PART OF THE APP*)
2. Create landing page with Docs section for the UltimateStackDeveloper app (TO DO)

## Getting started
Prerequisites
- Java 8 SDK (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- Apache Maven (https://maven.apache.org/download.cgi)
- Docker Desktop (including Docker CLI/Compose) (https://www.docker.com/products/docker-desktop)
### Setup on macOS:
### Setting up the Docker embedded PostgreSQL database
In order to persist the data we need a database (duh!). I've chosen the PostgreSQL, as it's easy and commonly used.
1. Launch `Terminal.app` and navigate (using `cd` command) to the `infrastructure/docker-compose/postgres` directory
2. Use the `docker compose up` command to start the database
3. In order to validate that database is running, go to your browser and go to `localhost:9081` - it should display `Adminer` application
4. Login to your local database using following credentials:
   - Server: db
   - Username: postgres
   - Password: b4Dg3R

Notes:
1. If you'd like to connect to the database remotely (e.g., via IntelliJ IDEA's Database connector) use the URL: `jdbc:postgresql://localhost:5431/postgres`
2. If you'd like to use your local database for the application, please update the `application.yml` (you can copy the URL from the point above)
3. You don't need to create the schemas/tables by yourself - simply follow the guidelines below and the Spring will create them for you
4. In order to populate database you can use the *.sql files from the `infrastructure/docker-compose/postgres/SQL Boot Files` directory

### Run the project
1. Cloning repository and installation
   - Launch `Terminal.app` and navigate (using `cd` command) to directory, where you'd like to store your copy of the source code
   - Use the `git clone https://github.com/catnippers/ultimate-stack-developer-backend.git` command to clone the repository to your local directory
   - Navigate (using `cd` command) to the root directory of the project (basically - it's where the `pom.xml` file is located)
   - Run the `mvn clean install` in order to download all the required dependencies to your project's directory

2. Running application on a local server
   - Launch `Terminal.app` and navigate (using `cd` command) to the project's directory
   - Use the `mvn spring-boot:run` command to launch the `spring-boot:run` from `Maven` plugins

### Setup on Windows: (TBA)
### Setup on Linux: (TBA)
