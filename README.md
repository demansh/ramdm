### For developer
Build
```shell
mvn clean install
```
Run
Set environmen variables:
- BOT_TOKEN //telegram bot token

```shell
cd scripts
./docker.sh
cd ..
mvn spring-boot:run --spring.profiles.active=dev
```

Connect to redis cli
```shell
docker exec -it redis-docker sh
redis-cli
```

Deploy to Heroku
```shell
heroku login
git push heroku master
heroku logs --tail
```
More about hosting spring app at heroku:
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
