package demo.proofit.service;

import demo.proofit.exception.PremiumCalculatorValidationException;
import demo.proofit.resource.Policy;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


/**
 * Policy validator class
 */
@Service
public class PolicyValidator {

    private Validator validator;

    public PolicyValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         this.validator = factory.getValidator();
    }

    /**
     * Validates Policy structure. Throws PremiumCalculatorValidationException when invalid
     * @param policy Policy object
     */
    public void validate(final Policy policy){
        final Set<ConstraintViolation<Policy>> constraints = this.validator.validate(policy);
        if(!constraints.isEmpty()){
            throw new PremiumCalculatorValidationException("Policy structure invalid.", constraints);
        }
    }
}
