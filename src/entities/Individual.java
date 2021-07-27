package entities;

public class Individual extends Taxpayer{

	private Double healtcareExpenses;

	public Individual() {
	}
	
	public Individual(String name, Double annualIncome, Double healtcareExpenses) {
		super(name, annualIncome);
		this.healtcareExpenses = healtcareExpenses;
	}
	
	public Double getHealtcareExpenses() {
		return healtcareExpenses;
	}

	public void setHealtcareExpenses(Double healtcareExpenses) {
		this.healtcareExpenses = healtcareExpenses;
	}

	@Override
	public Double totalTaxes() {
		if(annualIncome < 20000.00) {
			return (annualIncome * 0.15) - (healtcareExpenses * 0.5);
		}
		else {
			return (annualIncome * 0.25) - (healtcareExpenses * 0.5);
		}
	}
	
	public String toString() {
		return name
				+ ": $ "
				+ String.format("%.2f", totalTaxes());
	}
	
}
