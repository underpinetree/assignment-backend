# Full stack developer for customer facing website (req79330)

## Task description
Create a simple "contact list" web application that allows:
- Listing people (name and photo)
- Searching by name
-  Paging

## Run in local environment

Prerequisite

- PostgreSQL: version 14, create `kuehnenagel` database
- JDK: 11
- Redis: 6.0


### Create `kuehnenagel` database
    
    psql postgres
    postgres=# create user postgres;
    postgres=# create database kuehnenagel owner=postgres;
  

### Inputting initial data

The schema will be applied the first time it is started.

