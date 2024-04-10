**Getting Started**

This guide will walk you through running the Repository Scanner Service using Docker.

**Prerequisites**

- Docker installed on your machine.
- Clone the repository from GitHub.

**Running the Application**

**Build and Run the Backend:**

Navigate to the root directory of the backend application. repo-scan-app/repo-scan-ms

- Build the Docker image:

docker build -t repo-scan-ms .

- Run the container:

docker run -p 8081:8081 repo-scan-ms

This will start the backend application on http://localhost:8081.

**Build and Run the Frontend:**

Navigate to the root directory of the frontend application. repo-scan-app/repo-scan-ui

- Build the Docker image:

docker build -t repo-scan-ui .

- Run the container:

docker run -p 3000:80 repo-scan-ui

This will start the frontend application on http://localhost:3000.