###README

##Source
As source I used this blog article:
http://manuel.kiessling.net/2015/01/19/setting-up-a-scala-sbt-multi-project-with-cassandra-connectivity-and-migrations/

Thanks to Manuel Kiessling at this point

## Prerequisite

To make tests green run the following cql command:

```CREATE KEYSPACE IF NOT EXISTS test WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': 1 };```
