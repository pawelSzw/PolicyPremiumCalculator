package demo.proofit.service;

import demo.proofit.PremiumCalculatorApplication;
import demo.proofit.resource.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Premium Calculator service Test
 */
@SpringBootTest(classes = {PremiumCalculatorApplication.class})
public class PremiumCalculatorIntTest {

    @Autowired
    private PremiumCalculator premiumCalculator;

    @Test
    public void test_calculate_scenario_one(){

        //given
        final PolicySubObject policySubObjectOne = PolicySubObject.builder().sumInsured(new BigDecimal(100)).riskType(RiskType.FIRE).build();
        final PolicySubObject policySubObjectTwo = PolicySubObject.builder().sumInsured(new BigDecimal(8)).riskType(RiskType.THEFT).build();

        final List<PolicySubObject> policySubObjectList = new ArrayList<>();
        policySubObjectList.add(policySubObjectOne);
        policySubObjectList.add(policySubObjectTwo);

        final List<PolicyObject> policyObjectList = new ArrayList<>();
        final PolicyObject policyObject = PolicyObject.builder().name("House").subObjects(policySubObjectList).build();
        policyObjectList.add(policyObject);

        //when
        final Policy policy = Policy.builder().policyNumber("1").status(PolicyStatus.APPROVED).policyObjects(policyObjectList).build();

        //then
        Assertions.assertEquals(new BigDecimal("2.28"), premiumCalculator.calculate(policy));
    }

    @Test
    public void test_calculate_scenario_two(){

        //given
        final PolicySubObject policySubObjectOne = PolicySubObject.builder().sumInsured(new BigDecimal(500.00)).riskType(RiskType.FIRE).build();
        final PolicySubObject policySubObjectTwo = PolicySubObject.builder().sumInsured(new BigDecimal(102.51)).riskType(RiskType.THEFT).build();

        final List<PolicySubObject> policySubObjectList = new ArrayList<>();
        policySubObjectList.add(policySubObjectOne);
        policySubObjectList.add(policySubObjectTwo);

        final List<PolicyObject> policyObjectList = new ArrayList<>();
        final PolicyObject policyObject = PolicyObject.builder().name("House").subObjects(policySubObjectList).build();
        policyObjectList.add(policyObject);

        //when
        final Policy policy = Policy.builder().policyNumber("1").status(PolicyStatus.REGISTERED).policyObjects(policyObjectList).build();

        //then
        Assertions.assertEquals(new BigDecimal("17.13"), premiumCalculator.calculate(policy));
    }

}
