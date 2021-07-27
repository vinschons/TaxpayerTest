package entities;

public class Company extends Taxpayer{

	private Integer employeeNumber;
	
	public Company() {
		
	}
	
	public Company(String name, Double annualIncome, Integer employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public Double totalTaxes() {
		if(employeeNumber >= 10) {
			return annualIncome * 0.14;
		}
		else {
			return annualIncome * 0.16;
		}
	}
	
	public String toString() {
		return name
				+ ": $ "
				+ String.format("%.2f", totalTaxes());
	}
	
}
