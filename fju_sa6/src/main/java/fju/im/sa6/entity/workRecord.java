package fju.im.sa6.entity;

import java.util.Date;

public class workRecord {
	
	private Date date ;
	
	private Date onworkTime;

	private Date offworkTime;

	
	//Constructor
	public workRecord(Date date, Date workTime ,boolean onWork) {
		if(onWork == true){
			this.date = date;
			this.onworkTime = workTime;
		}
		else{
			this.date = date;
			this.offworkTime = workTime;
		}
	}


	public Date getOnworkTime() {
		return onworkTime;
	}


	public void setOnworkTime(Date onworkTime) {
		this.onworkTime = onworkTime;
	}


	public Date getOffworkTime() {
		return offworkTime;
	}


	public void setOffworkTime(Date offworkTime) {
		this.offworkTime = offworkTime;
	}


	public Date getDate() {
		return date;
	}

	
	

}
