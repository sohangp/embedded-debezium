# Change Data Capture (CDC) with Embedded Debezium and SpringBoot

Blog URL: https://medium.com/@sohan_ganapathy/change-data-capture-cdc-with-embedded-debezium-and-springboot-6f10cd33d8ec

## Prerequisites
- [Docker](https://docs.docker.com/v17.09/engine/installation/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Installing required tools

Once the prerequisites are installed, run the command.

```shell
docker-compose up -d
```

## Student table

```sql
CREATE TABLE public.student
(
    id integer NOT NULL,
    address character varying(255),
    email character varying(255),
    name character varying(255),
    CONSTRAINT student_pkey PRIMARY KEY (id)
);
```

## Starting the SpringBoot application

Go to the folder `student-cdc-relay`, run the command

```shell
mvn spring-boot:run
```

## Scripts to Insert, Update and Delete a record on Postgres

```sql
INSERT INTO STUDENT(ID, NAME, ADDRESS, EMAIL) VALUES('1','Jack','Dallas, TX','jack@gmail.com');

UPDATE STUDENT SET EMAIL='jill@gmail.com', NAME='Jill' WHERE ID = 1; 

DELETE FROM STUDENT WHERE ID = 1;
```

## Elasticsearch commands to test if CDC worked !

```shell
curl -X GET http://localhost:9200/student/student/1?pretty=true
```
