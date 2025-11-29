#!/bin/bash

# URL of your Spring Boot endpoint
URL="http://localhost:8080/api/pms/project/create-project"

# JSON payload
JSON_PAYLOAD=$(cat <<EOF
{
  "projectName": "My First Project",
  "projectType": "DEDICATED",
  "projectStartDate": "2025-12-01"
}
EOF
)

# Execute POST request
curl -X POST "$URL" \
     -H "Content-Type: application/json" \
     -d "$JSON_PAYLOAD" \
