docker run --rm --name redis-docker \
-p 6379:6379 -v redis.conf:/usr/local/etc/redis/redis.conf -d redis
