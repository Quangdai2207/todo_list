docker compose -f ../cicd/docker-compose.yml -f ../cid/docker-compose-test.yml up && \ 
docker compose ps && \
docker compose -f ../cicd/docker-compose.yml -f ../cicd/docker-compose-test.yml down -v