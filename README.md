<img alt="Catnippers Social Club" src="https://github.com/catnippers/catnippers-landing-page/blob/evan/src/images/catnippers_logotype-01%201.png" />

# Ultimate Stack Developer (Backend)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/ca2ee88e52a643fab2ba892a1cb73082)](https://www.codacy.com/gh/catnippers/ultimate-stack-developer-backend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=catnippers/ultimate-stack-developer-backend&amp;utm_campaign=Badge_Grade)

Created by Tomasz Buga

GitHub: https://github.com/n4bik

LinkedIn: https://www.linkedin.com/in/tomasz-buga-79933886/

mail: kontakt@tomaszbuga.pl

## Project Overview
Live Demo: https://ultimatestackdeveloper.netlify.com

**Ultimate Stack Developer** is an application for managing micro-scale blog about whatever you can imagine!

## Tech Stack
Backend part is based on:

`Java 11` with `Spring Boot`

`GraphQL` for managing API communication between the frontend and the backend

`Docker` for easy application setup

## Key Files Description
`docker-compose.yml` - this file is used in order to spin up the application in a quick and easy way

`Dockerfile` - this file enables `docker-compose` to properly dockerize the app

(to dockerize - to set up application on the so-called `container`, therefore being able to deploy it, without a hustle on any docker-engine based environment (to smooth this process a little more, it's common to deploy multiple containers together using the docker-compose library)

`pom.xml` - this file contains all the dependencies that are being used by the application (and basically everything for the building/testing/deploying automation with Java)

## API & CORS (Cross-Origin-Resource-Sharing) Handling

Backend of the UltimateStackDeveloper app uses the CORS to secure API requests made by browsers and narrows it down
to `https://ultimatestackdevleoper.netlify.app` (disabled by default)

### CORS Security Toggle
Modify this line in order to remove/add CORS security `src/main/java/pl/tomaszbuga/ultimatestackdeveloper/config/JwtSecurityConfig.java:56` (``corsConfigurationSource()``)

## Getting started
### Prerequisites
Java 11 SDK (https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

Apache Maven (https://maven.apache.org/download.cgi)

Docker Desktop (including Docker CLI/Compose) (https://www.docker.com/products/docker-desktop)

### Clone the repository & run the project
Launch `Terminal.app` and navigate (using `cd` command) to directory, where you'd like to store your copy of the source code

Use the command below to clone the repository to your local directory
```
git clone https://github.com/catnippers/ultimate-stack-developer-backend.git
``` 

Navigate (using `cd` command) to the root directory of the project (basically - it's where the `pom.xml` file is located)

Run the command below in order to run the application and database in the docker containers using the `Docker Engine`

```
docker-compose up
``` 
