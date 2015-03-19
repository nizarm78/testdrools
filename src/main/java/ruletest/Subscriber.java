package ruletest;

import java.io.Serializable;

public class Subscriber implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer budget;
	private Boolean approved;
	
	public Subscriber(String name, Integer budget) {
		super();
		this.name = name;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Boolean IsApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Subscriber [name=" + name + ", budget=" + budget
				+ ", approved=" + approved + "]";
	}
	
	
}
