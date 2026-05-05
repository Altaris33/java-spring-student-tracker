#!/bin/bash

curl -X POST http://localhost:7070/students \
-H "Content-Type: application/json" \
-d '{
      "firstName": "Rean",
      "lastName": "Scharzer",
      "email": "rean.scharzer@thors.com"
    }'

echo

curl http://localhost:7070/students