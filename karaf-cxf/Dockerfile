#Java Image 
FROM openjdk:8

ENV KARAF_VERSION=4.1.1
WORKDIR /usr/local/workspace

#Pull down karaf 
RUN wget http://apache.cs.utah.edu/karaf/4.1.1/apache-karaf-${KARAF_VERSION}.tar.gz \
	&& mkdir apache-karaf; tar --strip=1 -C apache-karaf -xf apache-karaf-${KARAF_VERSION}.tar.gz 

#Figure out how to use WORKDIR here
#ENTRYPOINT ["/usr/local/workspace/apache-karaf"]
