docker rm -fv cinnamon-graphite
docker run -d --name cinnamon-graphite -p 8125:8125/udp hopsoft/graphite-statsd