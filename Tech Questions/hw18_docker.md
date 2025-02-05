## Steps:
    1. In SpringBoot application: write docker file
    2. In SpringBoot application: write docker compose file
    3. Build and run application: docker-compose up -d
    4. Run: docker build -t <dockerhub-username>/user-service:latest . # build image
    5. Run: docker login
    6. Run: docker tag <dockerhub-username>/user-service <dockerhub-username>/user-service:latest # make tag
    7. Run: docker push <dockerhub-username>/user-service:latest # push to repo
https://hub.docker.com/repository/docker/zifwang321/user-service/general