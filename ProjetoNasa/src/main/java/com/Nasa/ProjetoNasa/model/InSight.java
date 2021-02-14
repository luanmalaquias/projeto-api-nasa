package com.Nasa.ProjetoNasa.model;

public class InSight {

	public class Measurement {
		private String first;
		private String last;

		public String getFirst() {
			return first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getLast() {
			return last;
		}

		public void setLast(String last) {
			this.last = last;
		}
	}

	public class Air {
		public class Temperature {
			private String average;
			private String minimum;
			private String maximum;

			public String getAverage() {
				return average;
			}

			public void setAverage(String average) {
				this.average = average;
			}

			public String getMinimum() {
				return minimum;
			}

			public void setMinimum(String minimum) {
				this.minimum = minimum;
			}

			public String getMaximum() {
				return maximum;
			}

			public void setMaximum(String maximum) {
				this.maximum = maximum;
			}
		}

		public class Pressure {
			private String average;
			private String minimum;
			private String maximum;

			public String getAverage() {
				return average;
			}

			public void setAverage(String average) {
				this.average = average;
			}

			public String getMinimum() {
				return minimum;
			}

			public void setMinimum(String minimum) {
				this.minimum = minimum;
			}

			public String getMaximum() {
				return maximum;
			}

			public void setMaximum(String maximum) {
				this.maximum = maximum;
			}
		}

		private Temperature temperature;
		private Pressure pressure;

		public Temperature getTemperature() {
			return temperature;
		}

		public void setTemperature(Temperature temperature) {
			this.temperature = temperature;
		}

		public Pressure getPressure() {
			return pressure;
		}

		public void setPressure(Pressure pressure) {
			this.pressure = pressure;
		}
	}

	public class Wind {
		public class Speed {
			private String average;
			private String minimum;
			private String maximum;

			public String getAverage() {
				return average;
			}

			public void setAverage(String average) {
				this.average = average;
			}

			public String getMinimum() {
				return minimum;
			}

			public void setMinimum(String minimum) {
				this.minimum = minimum;
			}

			public String getMaximum() {
				return maximum;
			}

			public void setMaximum(String maximum) {
				this.maximum = maximum;
			}
		}

		public class Direction {
			private String point;
			private double degrees;
			private double up;
			private double right;

			public String getPoint() {
				return point;
			}

			public void setPoint(String point) {
				this.point = point;
			}

			public double getDegrees() {
				return degrees;
			}

			public void setDegrees(double degrees) {
				this.degrees = degrees;
			}

			public double getUp() {
				return up;
			}

			public void setUp(double up) {
				this.up = up;
			}

			public double getRight() {
				return right;
			}

			public void setRight(double right) {
				this.right = right;
			}
		}

		private Speed speed;
		
		private Object[] directions;
		
		public Speed getSpeed() {
			return speed;
		}

		public void setSpeed(Speed speed) {
			this.speed = speed;
		}

		public Object[] getDirections() {
			return directions;
		}

		public void setDirections(Object[] directions) {
			this.directions = directions;
		}

	}

	private String sol;
	private String season;
	private Measurement measurement;
	private Air air;
	private Wind wind;
	
	@Override
	public String toString() {
		String s = "";
		s += "Sol: " + sol + "\n";
		s += "Season: " + season + "\n";
		s += "Measurement First: " + measurement.getFirst() + "\n";
		s += "Measurement Last: " + measurement.getLast() + "\n\n";
		s += "Air Temperature Maximum: " + air.getTemperature().getMaximum() + " F\n";
		s += "Air Temperature Average: " + air.getTemperature().getAverage() + " F\n";
		s += "Air Temperature Minimum: " + air.getTemperature().getMinimum() + " F\n\n";
		s += "Air Pressure Maximum: " + air.getPressure().getMaximum() + "\n";
		s += "Air Pressure Average: " + air.getPressure().getAverage() + "\n";
		s += "Air Pressure Minimum: " + air.getPressure().getMinimum() + "\n\n";
		s += "Wind Speed Maximum: " + wind.getSpeed().getMaximum() + "\n";
		s += "Wind Speed Average: " + wind.getSpeed().getAverage() + "\n";
		s += "Wind Speed Minimum: " + wind.getSpeed().getMinimum() + "\n\n";
		s += "Wind Directions: \n";
		for(int i=0; i<wind.getDirections().length; i++) {
			s += wind.getDirections()[i].toString() + "\n";			
		}
		return s;
	}
	
	/*Get n Set*/

	public String getSol() {
		return sol;
	}

	public String getSeason() {
		return season;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public Air getAir() {
		return air;
	}

	public Wind getWind() {
		return wind;
	}

	public void setSol(String sol) {
		this.sol = sol;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public void setAir(Air air) {
		this.air = air;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	

}
