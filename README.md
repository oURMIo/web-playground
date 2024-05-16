# WEB Playground

## Overview

WEB Playground is a project designed to experiment with and test new features in web development.

## Getting Started

### Prerequisites

Ensure you have the following installed:

* Java Development Kit (JDK) 21 or higher
* Gradle

### Installation

1) Clone the repository:

```shell
git clone https://github.com/oURMIo/web-playground.git
cd web-playground
```

2) Build the project using Gradle:

```shell
gradle clean build -x test
```

3) Run the application:

```shell
gradle bootRun
```

## Accessing the Application

Once the application is running, you can access it via a web browser at:

```text
http://localhost
```

## Database Access

H2 Database console can be accessed at:

```text
http://localhost/h2-console
```

* JDBC URL: jdbc:h2:mem:testdb
* Username: root
* Password: root

Note : Before starting, I recommend changing the username and password

## Technologies Used

* Spring Web: For building web applications and RESTful services.
* Spring Security: For securing the application.
* Spring Data JPA: For database interactions and data management.
* H2 Database: An in-memory database for testing and development.
