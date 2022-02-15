package demo.proofit.service;

import demo.proofit.exception.PremiumCalculatorValidationException;
import demo.proofit.resource.Policy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Policy validator test
 */
public class PolicyValidatorTest {
    Policy policy;
    PolicyValidator policyValidator;

    @BeforeEach
    public void setUp(){
        policyValidator = new PolicyValidator();
    }
    @Test
    public void test_validate_throws_exception_when_policy_object_list_is_null(){
       policy = Policy.builder().policyNumber("Number").build();
       Assertions.assertThrows(PremiumCalculatorValidationException.class, () -> {
            policyValidator.validate(policy);
        });
   }


}
