package datadidit.car.mongo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import datadidit.car.mongo.Car;
import datadidit.car.mongo.CarDataProvider;

@Path("/")
public class CarResource {
	private CarDataProvider provider; 
	
	/*private String dbName;
	
	private Integer mongoPort;
	
	private String mongoUrl;
	
	private String collection;
	*/
	
	public CarResource(){

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Car getRandomCar(){
		return provider.getNCarsFromMongo(1).get(0);
	}
	
	@Path("/{n}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCars(@PathParam("n") Integer n){
		return provider.getNCarsFromMongo(n);
	}

	public CarDataProvider getProvider() {
		return provider;
	}

	public void setProvider(CarDataProvider provider) {
		this.provider = provider;
	}

	/*public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Integer getMongoPort() {
		return mongoPort;
	}

	public void setMongoPort(Integer mongoPort) {
		this.mongoPort = mongoPort;
	}

	public String getMongoUrl() {
		return mongoUrl;
	}

	public void setMongoUrl(String mongoUrl) {
		this.mongoUrl = mongoUrl;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}
	*/
}
