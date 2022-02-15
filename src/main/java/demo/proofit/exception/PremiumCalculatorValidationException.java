package demo.proofit.exception;

import demo.proofit.resource.Policy;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Policy validation exceptions
 */
@Getter
public class PremiumCalculatorValidationException extends RuntimeException{

    private Set<ConstraintViolation<Policy>> policyValidationErrors;

    public PremiumCalculatorValidationException(final String message, final Set<ConstraintViolation<Policy>> policyValidationErrors){
        super(message);
        this.policyValidationErrors = policyValidationErrors;
    }

}
