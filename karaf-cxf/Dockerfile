#Java Image 
FROM maven:3.5.0-jdk-8

ENV KARAF_VERSION=4.1.1
WORKDIR /usr/local/workspace

ADD feature feature/

#Pull down karaf and set it up
RUN wget http://apache.cs.utah.edu/karaf/4.1.1/apache-karaf-${KARAF_VERSION}.tar.gz \
	&& mkdir apache-karaf; tar --strip=1 -C apache-karaf -xf apache-karaf-${KARAF_VERSION}.tar.gz 

#TODO Can probably break it off here and start a new image based on above
#Pull deploy CXF into karaf using a feature
#RUN 

#Figure out how to use WORKDIR here
#ENTRYPOINT ["/usr/local/workspace/apache-karaf"]

CMD /bin/bash
