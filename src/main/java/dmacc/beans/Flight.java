package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String departCity;
	private String destinCity;
	private int capacity;
	private double seatCostAmt;
	
	public Flight() {
	}

	public Flight(String departCity, String destinCity, int capacity, double seatCostAmt) {
		super();
		//this.id = id;
		this.departCity = departCity;
		this.destinCity = destinCity;
		this.capacity = capacity;
		this.seatCostAmt = seatCostAmt;
	}



	public long getId() {
		return id;
	}

	

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getDestinCity() {
		return destinCity;
	}

	public void setDestinCity(String destinCity) {
		this.destinCity = destinCity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getSeatCostAmt() {
		return seatCostAmt;
	}

	public void setSeatCostAmt(double seatCostAmt) {
		this.seatCostAmt = seatCostAmt;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departCity=" + departCity + ", destinCity=" + destinCity + ", capacity="
				+ capacity + ", seatCostAmt=" + seatCostAmt + "]";
	}



}
