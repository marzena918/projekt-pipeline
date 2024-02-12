#!/bin/bash

docker pull owasp/zap2docker-stable
docker run -i owasp/zap2docker-stable zap-baseline.py -t "http://3.135.209.44:4200/" -l PASS > zap_baseline_report.html

echo $? > /dev/null