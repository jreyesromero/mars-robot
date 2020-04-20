#!/bin/bash
# Start application with spring-boot
#cd ..
#./mvnw spring-boot:run &
INPUT_FILE=$1
OUTPUT_FILE=$2

#Test curl command
JSON_DATA=$(cat $INPUT_FILE)
curl -o $OUTPUT_FILE --header "Content-Type: application/json" \
  --request POST \
  --data "${JSON_DATA}" \
  http://localhost:8080/robot
