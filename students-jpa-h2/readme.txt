
BUILD:
------
docker build -f Dockerfile -t students-jpa-h2-0.0.1 .  

RUN:
----
docker run -p 8085:8085 students-jpa-h2-0.0.1

ACCESS:
-------
http://localhost:8085/index