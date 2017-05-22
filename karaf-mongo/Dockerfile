FROM maven:3.5.0-jdk-8

ENV KARAF_VERSION=4.0.9

WORKDIR /usr/local/workspace

#Add REST app
ADD rest rest/

#Pull down karaf and set it up
RUN wget http://apache.cs.utah.edu/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz \
	&& mkdir apache-karaf; tar --strip=1 -C apache-karaf -xf apache-karaf-${KARAF_VERSION}.tar.gz 

#Add REST app
RUN cd /usr/local/workspace/rest; mvn clean install -B -U \
	&& cp target/*.kar /usr/local/workspace/apache-karaf/deploy 

EXPOSE 8181

ENTRYPOINT ["apache-karaf/bin/karaf"]