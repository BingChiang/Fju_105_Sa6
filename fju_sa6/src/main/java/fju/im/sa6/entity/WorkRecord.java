package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class WorkRecord {
	
	private Date date ;
	
	private Date onworkTime;

	private Date offworkTime;

	
	//Constructor
	public WorkRecord(Date date, Date workTime ,boolean onWork) {
		if(onWork == true){
			this.date = date;
			this.onworkTime = workTime;
		}
		else{
			this.date = date;
			this.offworkTime = workTime;
		}
	}
	
	public WorkRecord(){
		this.date = null;
		this.onworkTime = null;
		this.offworkTime = null;
		
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
	
	
	public ArrayList<StaffDefault> getList(int i) {
		return getList(i);
	}
	

}
