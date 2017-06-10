docker rm -fv cinnamon-influxdb
docker run -d --name cinnamon-influxdb -p 8086:8086 influxdb:1.2-alpine

sleep 10s
curl -X POST -G http://localhost:8086/query --data-urlencode "q=CREATE DATABASE telegraf"