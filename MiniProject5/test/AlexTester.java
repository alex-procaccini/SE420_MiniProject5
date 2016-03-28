package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.CommissionCalculator;
import app.iCommissionCalculator;

public class AlexTester {

	@Test
	public void belowComTest() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 1999);
		assertEquals(0, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void atComTest() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 2000);
		assertEquals(40, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void aboveComTest() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 2001);
		assertEquals(40.02, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void belowComTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 4999);
		assertEquals(0, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void atComTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 5000);
		assertEquals(200, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void aboveComTestEx() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.EXPERIENCED);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 5001);
		assertEquals(200.04, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void multiSaleTest() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 2500);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 2500);
		calc.addSale(iCommissionCalculator.BASIC_ITEM, 1000);
		assertEquals(120, calc.calculateCommission(), 0.01);
	}
	
	@Test
	public void otherItemsTest() {
		CommissionCalculator calc = new CommissionCalculator("Jane Doe", iCommissionCalculator.PROBATIONARY);
		calc.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 2500);
		calc.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 2500);
		calc.addSale(iCommissionCalculator.CONSULTING_ITEM, 10000);
		assertEquals(400, calc.calculateCommission(), 0.01);
	}
}
