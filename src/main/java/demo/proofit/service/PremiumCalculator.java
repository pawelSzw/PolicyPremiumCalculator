package demo.proofit.service;

import demo.proofit.config.PremiumCalculatorConfig;
import demo.proofit.resource.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Premium Calculator service
 */
@Service
public class PremiumCalculator {

    private PremiumCalculatorStrategyManager premiumCalculatorStrategyManager;

    private PolicyValidator policyValidator;


    @Autowired
    public PremiumCalculator(final PremiumCalculatorStrategyManager premiumCalculatorStrategyManager, final PolicyValidator policyValidator){
        this.premiumCalculatorStrategyManager = premiumCalculatorStrategyManager;
        this.policyValidator = policyValidator;
    }

    /**
     * Calculates total premium for policy
     *
     * @param policy Policy
     * @return calculated premium for Policy
     */

    public BigDecimal calculate(final Policy policy) {
        policyValidator.validate(policy);
        return premiumCalculatorStrategyManager.getSupportedRisksMap().keySet().stream().map(key->premiumCalculatorStrategyManager.getSupportedRisksMap().get(key).calculatePremium(policy,key)).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(PremiumCalculatorConfig.SCALE, PremiumCalculatorConfig.ROUNDING_MODE);
    }



}
