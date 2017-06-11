DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

docker rm -fv cinnamon-grafana
docker run -d --name cinnamon-grafana \
 -p 3000:3000 \
 --link cinnamon-graphite:graphite \
 -v $DIR/dashboards:/dashboards \
 -e GF_DASHBOARDS_JSON_ENABLED='true' \
 -e GF_DASHBOARDS_JSON_PATH='/dashboards' \
 grafana/grafana