package demo.proofit.service;

import demo.proofit.resource.Policy;
import demo.proofit.resource.RiskType;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

/**
 * Calculation strategy for FIRE risk
 */
@Component
public class PremiumFireCalculationStrategy implements IRiskCalculationStrategy{

    private final static BigDecimal DEFAULT_COEFFICIENT_FIRE =  BigDecimal.valueOf(0.014);
    private final static BigDecimal COEFFICIENT_FOR_FIRE_GREATER_THAN_ONE_HUNDRED = BigDecimal.valueOf(0.024);
    private final static BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    @Override
    public BigDecimal calculatePremium(final Policy policy, final RiskType riskType) {

        BigDecimal premiumFire;
        final BigDecimal sumInsuredFire = calculateSumInsured(policy, riskType);

        if (sumInsuredFire.compareTo(ONE_HUNDRED) <= 0) {
            premiumFire = sumInsuredFire.multiply(DEFAULT_COEFFICIENT_FIRE);
        } else {
            premiumFire =  sumInsuredFire.multiply(COEFFICIENT_FOR_FIRE_GREATER_THAN_ONE_HUNDRED);
        }

        return premiumFire;
    }

}
