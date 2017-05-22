package datadidit.car.mongo;

public class Car {
	private Integer year; 
	
	private String make; 
	
	private String model;
	
	public Car(){
		
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(int i) {
		this.year = i;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
