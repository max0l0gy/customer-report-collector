# Getting Started

## Test
````
./mvnw test
````

## Build
````
 ./mvnw package -DskipTests 
````

## Docker
Install

Build
````
docker build -t maxmorev/customer-report-collector .
````
Run
````
docker run -i --rm -p 8080:8080 \
--name customer-report-collector \
maxmorev/customer-report-collector
````
