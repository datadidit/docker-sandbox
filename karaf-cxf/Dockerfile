#Java Image 
FROM maven:3.5.0-jdk-8

#4.1.1 has issues ssh reset...
ENV KARAF_VERSION=4.0.9
WORKDIR /usr/local/workspace

#Pull down karaf and set it up
RUN wget http://apache.cs.utah.edu/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz \
	&& mkdir apache-karaf; tar --strip=1 -C apache-karaf -xf apache-karaf-${KARAF_VERSION}.tar.gz 

RUN rm /usr/local/workspace/apache-karaf-${KARAF_VERSION}.tar.gz 

COPY target/*.kar /usr/local/workspace/apache-karaf/deploy

#Figure out how to use WORKDIR here
#ENTRYPOINT ["/usr/local/workspace/apache-karaf"]
#Expose ports
EXPOSE 8181

#CMD /bin/bash
ENTRYPOINT ["apache-karaf/bin/karaf"]
