# Build Imgae Jenkins tren jdk17 tren OS linux/amd64
FROM jenkins/inbound-agent:latest-alpine-jdk17
USER root
RUN apk add python3
RUN apk add py3-pip
RUN apk add --no-cache docker-cli docker-cli-compose
USER jenkins