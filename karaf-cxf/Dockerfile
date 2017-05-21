#Java Image 
FROM maven:3.5.0-jdk-8

#4.1.1 has issues ssh reset...
ENV KARAF_VERSION=4.0.9
WORKDIR /usr/local/workspace

ADD feature feature/

#Pull down karaf and set it up
RUN wget http://apache.cs.utah.edu/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz \
	&& mkdir apache-karaf; tar --strip=1 -C apache-karaf -xf apache-karaf-${KARAF_VERSION}.tar.gz 

#TODO Can probably break it off here and start a new image based on above
#Pull deploy CXF into karaf using a feature
RUN cd /usr/local/workspace/feature; mvn clean install -B -U \
	&& cp target/*.kar /usr/local/workspace/apache-karaf/deploy 

#Figure out how to use WORKDIR here
#ENTRYPOINT ["/usr/local/workspace/apache-karaf"]
#Expose ports
EXPOSE 8181

#CMD /bin/bash
ENTRYPOINT ["apache-karaf/bin/karaf"]
