![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/claudioaltamura/java-micrometer-example/build-gradle-project.yml?branch=main)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# java-micrometer-example
Java Micrometer example with Prometheus

### Service

http://localhost:8080/prometheus

```
# HELP counter_total  
# TYPE counter_total counter
counter_total{counter="mycounter",} 1001.0
```

### Prometheus
    
http://localhost:9090/


#### promQL counter_total example

```
max_over_time(counter_total[5m])
max_over_time(rate(counter_total[1m])[5m:])
increase(counter_total[5m])
```
