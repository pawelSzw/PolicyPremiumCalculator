package demo.proofit.service;

import demo.proofit.resource.Policy;
import demo.proofit.resource.RiskType;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

/**
 * Calculation strategy for THEFT risk
 */
@Component
public class PremiumTheftCalculationStrategy implements IRiskCalculationStrategy{

    private final static BigDecimal DEFAULT_COEFFICIENT_THEFT = BigDecimal.valueOf(0.11);
    private final static BigDecimal COEFFICIENT_FOR_GREATER_THAN_ONE_FIFTEEN = BigDecimal.valueOf(0.05);
    private final static BigDecimal FIFTEEN = BigDecimal.valueOf(15);

    @Override
    public BigDecimal calculatePremium(final Policy policy, final RiskType riskType) {

        final BigDecimal sumInsuredTheft = calculateSumInsured(policy, riskType);
        BigDecimal premiumTheft;

        if (sumInsuredTheft.compareTo(FIFTEEN) < 0) {
            premiumTheft = sumInsuredTheft.multiply(DEFAULT_COEFFICIENT_THEFT);
        } else {
            premiumTheft =  sumInsuredTheft.multiply(COEFFICIENT_FOR_GREATER_THAN_ONE_FIFTEEN);
        }
        return  premiumTheft;
    }

}
