FROM mongo

WORKDIR /usr/local/workspace

ADD data.json .

#Import data into mongo using mongo-import script
RUN mkdir -p /data/myDB; mkdir logs; mongod --fork --logpath /usr/local/workspace/logs/mongod.log --dbpath /data/myDB \ 
&& mongoimport --db example --collection cars --file data.json --jsonArray \
&& mongod --dbpath /data/myDB --shutdown 
&& rm data.json

VOLUME /data/myDB

EXPOSE 27017

#Need to run a command so docker doesn't immediately exit
ENTRYPOINT ["mongod", "--dbpath", "/data/myDB"]
