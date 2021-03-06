/*This class contains JUnit test cases for the calculateBonusCommission() method in CommissionCalcultor.
 * It checks whether a sale is eligibile for a bonus commission.
 * @author Krushan Patel
 * @version 1.0 March 27, 2016
 */



package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.CommissionCalculator;
import app.iCommissionCalculator;

public class KrushanTester {
	
	@Test
	public void belowBonusTest() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 49999);
		assertEquals(0, calc.calculateBonusCommission(),0.01);
	}
	
	@Test
	public void atBonusTest() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 50000);
		assertEquals(250, calc.calculateBonusCommission(),0.01);
	}
	
	@Test
	public void aboveBonusTest() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 50001);
		assertEquals(250.005, calc.calculateBonusCommission(),0.01);
	}
	
	
	@Test
	public void belowBonusTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 99999);
		assertEquals(0, calc.calculateBonusCommission(),0.01);
	}
	
	@Test
	public void atBonusTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 100000);
		assertEquals(1500, calc.calculateBonusCommission(),0.01);
	}
	
	@Test
	public void aboveBonusTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 100001);
		assertEquals(1500.015, calc.calculateBonusCommission(),0.01);
	}
	
	@Test
	public void multipleSalesTest() {
		CommissionCalculator calc = new CommissionCalculator("Krushan Patel", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 60000);
		calc.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 2500);
		calc.addSale(iCommissionCalculator.CONSULTING_ITEM, 75000);
		assertEquals(675.00, calc.calculateBonusCommission(), 0.01);
	}
	

	
	
	
}
