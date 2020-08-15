package com.quinnox.qtvt.BO;

public class HomePluckCardBO {
	
	private long submittedHours;
	private long allocatedHours;
	private long lapsedHours;
	
	
	public long getSubmittedHours() {
		return submittedHours;
	}


	public void setSubmittedHours(long submittedHours) {
		this.submittedHours = submittedHours;
	}


	public long getAllocatedHours() {
		return allocatedHours;
	}


	public void setAllocatedHours(long allocatedHours) {
		this.allocatedHours = allocatedHours;
	}


	public long getLapsedHours() {
		return lapsedHours;
	}


	public void setLapsedHours(long lapsedHours) {
		this.lapsedHours = lapsedHours;
	}


	@Override
	public String toString() {
		return "HomePluckCards [submittedHours=" + submittedHours + ", allocatedHours=" + allocatedHours
				+ ", lapsedHours=" + lapsedHours + "]";
	}
	

}
