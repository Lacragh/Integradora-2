package model;

public class EnvironmentalManagementPlan {
	private double compliancePercentage;

	public EnvironmentalManagementPlan(double compliancePercentage) {
		this.compliancePercentage = compliancePercentage;
	}

	public double getCompliancePercentage() {
		return compliancePercentage;
	}

	public void setCompliancePercentage(double compliancePercentage) {
		this.compliancePercentage = compliancePercentage;
	}
}
