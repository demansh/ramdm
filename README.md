### For developer
#### Build
```shell
mvn clean install
```
#### Run locally:

Set environment variable:
- BOT_TOKEN //telegram bot token

Run ngrok and set its url to the `env.rootUrl` in `application-dev.properties`

Run redis in docker:
```shell
cd scripts
./docker.sh
cd ..
```
Launch spring boot app with `dev` profile
```shell
mvn spring-boot:run --spring.profiles.active=dev
```

Connect to redis cli
```shell
docker exec -it redis-docker sh
redis-cli
```

#### Deploy to Heroku:
Heroku launch command is in `Procfile`.

To deploy to heroku run in shell:
```shell
heroku login
git push heroku master
heroku logs --tail
```
More about hosting spring app at heroku:
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
