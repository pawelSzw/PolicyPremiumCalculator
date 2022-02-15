package demo.proofit.service;

import demo.proofit.config.PremiumCalculatorConfig;
import demo.proofit.resource.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * PremiumTheftCalculationStrategyTest test class
 */
public class PremiumTheftCalculationStrategyTest {

    private Policy policy;
    private PremiumTheftCalculationStrategy premiumTheftCalculationStrategy;


    @BeforeEach
    public void setUp(){

        final PolicySubObject policySubObjectOne = PolicySubObject.builder().sumInsured(new BigDecimal(129.1)).riskType(RiskType.THEFT).build();
        final PolicySubObject policySubObjectTwo = PolicySubObject.builder().sumInsured(new BigDecimal(233.1)).riskType(RiskType.THEFT).build();
        final PolicySubObject policySubObjectThree = PolicySubObject.builder().sumInsured(new BigDecimal(233.22)).riskType(RiskType.FIRE).build();

        final List<PolicySubObject> policySubObjectList = new ArrayList<>();
        policySubObjectList.add(policySubObjectOne);
        policySubObjectList.add(policySubObjectTwo);
        policySubObjectList.add(policySubObjectThree);

        final List<PolicyObject> policyObjectList = new ArrayList<>();
        final PolicyObject policyObject = PolicyObject.builder().name("Policy").subObjects(policySubObjectList).build();
        policyObjectList.add(policyObject);
        policy = Policy.builder().policyNumber("1").status(PolicyStatus.APPROVED).policyObjects(policyObjectList).build();

        premiumTheftCalculationStrategy = new PremiumTheftCalculationStrategy();
    }

    @Test
    public void test_calculateSumInsured(){
        Assertions.assertEquals( BigDecimal.valueOf(362.20).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE), premiumTheftCalculationStrategy.calculateSumInsured(policy, RiskType.THEFT).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE));
    }

    @Test
    public void test_calculatePremium(){
        Assertions.assertEquals(BigDecimal.valueOf(18.11).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE), premiumTheftCalculationStrategy.calculatePremium(policy, RiskType.THEFT).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE));
    }
}
