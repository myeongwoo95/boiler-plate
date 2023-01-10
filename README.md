# mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:8.0

# redis
docker run --name redis -d -p 6379:6379 redis:alpine

# yml 추가
file:
  path:
    image:  C:/upload/photogram/image/
    profile: C:/upload/photogram/profile/

