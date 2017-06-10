docker rm -fv cinnamon-grafana
docker run -d --name cinnamon-grafana -p 3000:3000 --link cinnamon-graphite:graphite grafana/grafana