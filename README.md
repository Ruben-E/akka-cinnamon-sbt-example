# AKKA Cinnamon SBT example

This is an example project with Cinnamon configured for SBT. Comes with Graphite and Grafana as Docker containers to visualise the metrics. JVM metrics are configured as well.

## Prerequisites

* Docker
* Sbt

## How to run

1. **Start Graphite:**
  $ ./graphite/run-graphite.sh
2. **Start Grafana:**
  $ ./grafana/run-grafana.sh
3. **Configure a Grahite datasource in Grafana**:
Graphite is linked to the Grafana Docker container as ``graphite`` (port 80). So the datasource URL should be ``http://graphite``
4. **Start application:**
  $ sbt run