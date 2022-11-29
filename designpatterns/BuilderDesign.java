package com.java.designpatterns;

class vehicle {
	
	private String engineName;
	private int wheel;
	private int airbags;
	
	public String getEngineName() {
		return engineName;
	}

	public int getWheel() {
		return wheel;
	}

	public int getAirbags() {
		return airbags;
	}
	
	private vehicle(VehicleBuilder builder) {

		this.airbags=builder.airbags;
		this.engineName=builder.engineName;
		this.wheel=builder.wheel;

	}
	
	public String toString() {
		return "vehicle [engineName=" + engineName + ", wheel=" + wheel + ", airbags=" + airbags + "]";
	}
	
	public static class VehicleBuilder{

		private String engineName;
		private int wheel;
		private int airbags;

		public VehicleBuilder(String engineName, int wheel) {
			this.engineName = engineName;
			this.wheel = wheel;
		}

		public VehicleBuilder setAirbags(int airbags) {
			this.airbags = airbags;
			return this;
		}

		public vehicle build() {
			
			vehicle v = new vehicle(this);
			return v;
		}
	}	
}