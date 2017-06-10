DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

docker rm -fv cinnamon-telegraf
docker run -d --name cinnamon-telegraf --link cinnamon-influxdb:influxdb -p 8125:8125/udp -v $DIR/telegraf.conf:/etc/telegraf/telegraf.conf:ro telegraf:alpine

