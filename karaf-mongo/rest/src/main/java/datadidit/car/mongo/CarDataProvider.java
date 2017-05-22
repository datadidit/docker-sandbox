package datadidit.car.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class CarDataProvider {
	private MongoClient client;
	
	private MongoCollection collection;
	
	private String mongoUrl;
	
	private Integer mongoPort;

	public CarDataProvider(String mongoUrl, Integer mongoPort, String dbName, String collectionName){
		this.mongoPort = mongoPort;
		this.mongoUrl = mongoUrl;
		
		client = new MongoClient(mongoUrl, mongoPort);
		
		this.collection = client.getDatabase(dbName).getCollection(collectionName);
	}
	
	public List<Car> getNCarsFromMongo(Integer n){
		List<Car> cars = new ArrayList<>();
		
		MongoCursor cursor = collection.find().iterator();
		
		int i=0;
		while(cursor.hasNext()){
			Document returnedDoc = (Document) cursor.next();
			
			cars.add(this.getCarFromDocument(returnedDoc));
			i++;
			if(i>n)
				break;
		}
		
		return cars;
	}
	
	public Car getCarFromDocument(Document d){
		Map<String, Object> map = new HashMap<>(); 
		
		for(Map.Entry<String, Object> entry : d.entrySet()){
			map.put(entry.getKey(), entry.getValue());
		}
		
		Car car = new Car();
		car.setMake(map.get("make").toString());
		car.setModel(map.get("model").toString());
		car.setYear(Integer.parseInt(map.get("year").toString()));
		
		return car;
	}
	
	public String getMongoUrl() {
		return mongoUrl;
	}

	public void setMongoUrl(String mongoUrl) {
		this.mongoUrl = mongoUrl;
	}

	public Integer getMongoPort() {
		return mongoPort;
	}

	public void setMongoPort(Integer mongoPort) {
		this.mongoPort = mongoPort;
	}
}
