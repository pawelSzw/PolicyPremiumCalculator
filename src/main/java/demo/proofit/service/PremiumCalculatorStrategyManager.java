package demo.proofit.service;

import demo.proofit.resource.RiskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Strategy manager for calculating premium calculator. Maps RiskTypes to calculation strategies
 */
@Component
public class PremiumCalculatorStrategyManager {

    private PremiumFireCalculationStrategy premiumFireCalculationStrategy;

    private PremiumTheftCalculationStrategy premiumTheftCalculationStrategy;

    private final Map<RiskType, IRiskCalculationStrategy> supportedRisksMap = new HashMap<>(2);

    @Autowired
    public PremiumCalculatorStrategyManager(final PremiumFireCalculationStrategy premiumFireCalculationStrategy, final PremiumTheftCalculationStrategy premiumTheftCalculationStrategy){
        this.premiumFireCalculationStrategy = premiumFireCalculationStrategy;
        this.premiumTheftCalculationStrategy = premiumTheftCalculationStrategy;
        supportedRisksMap.put(RiskType.FIRE, this.premiumFireCalculationStrategy);
        supportedRisksMap.put(RiskType.THEFT, this.premiumTheftCalculationStrategy);
    }

    /**
     *
     * @return Map of riskTypes and RiskCalculation strategies
     */
    public Map<RiskType, IRiskCalculationStrategy> getSupportedRisksMap() {
        return supportedRisksMap;
    }
}
