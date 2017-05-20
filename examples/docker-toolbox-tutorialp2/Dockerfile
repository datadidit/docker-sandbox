#Base image
FROM ubuntu:14.04

# Commands to run 
RUN apt-get update && apt-get install -y curl \
										vim

CMD echo $(which curl)
#Confirm Curl installed
#RUN echo $(which curl) 
