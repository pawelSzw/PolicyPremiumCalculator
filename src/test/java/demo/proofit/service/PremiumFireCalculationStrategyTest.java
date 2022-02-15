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
 * PremiumFireCalculationStrategy test class
 */
public class PremiumFireCalculationStrategyTest {

    private Policy policy;
    private PremiumFireCalculationStrategy premiumFireCalculationStrategy;


    @BeforeEach
    public void setUp(){

        final PolicySubObject policySubObjectOne = PolicySubObject.builder().sumInsured(new BigDecimal(100)).riskType(RiskType.FIRE).build();
        final PolicySubObject policySubObjectTwo = PolicySubObject.builder().sumInsured(new BigDecimal(102)).riskType(RiskType.FIRE).build();

        final List<PolicySubObject> policySubObjectList = new ArrayList<>();
        policySubObjectList.add(policySubObjectOne);
        policySubObjectList.add(policySubObjectTwo);

        final List<PolicyObject> policyObjectList = new ArrayList<>();
        final PolicyObject policyObject = PolicyObject.builder().name("Fire Policy").subObjects(policySubObjectList).build();
        policyObjectList.add(policyObject);
        policy = Policy.builder().policyNumber("1").status(PolicyStatus.APPROVED).policyObjects(policyObjectList).build();

        premiumFireCalculationStrategy = new PremiumFireCalculationStrategy();
    }

    @Test
    public void test_calculateSumInsured(){
        Assertions.assertEquals(BigDecimal.valueOf(202).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE), premiumFireCalculationStrategy.calculateSumInsured(policy, RiskType.FIRE).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE));
    }

    @Test
    public void test_calculatePremium(){
        Assertions.assertEquals(BigDecimal.valueOf(4.848).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE), premiumFireCalculationStrategy.calculatePremium(policy, RiskType.FIRE).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE));
    }
}
