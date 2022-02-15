package demo.proofit.service;

import demo.proofit.resource.Policy;
import demo.proofit.resource.PolicySubObject;
import demo.proofit.resource.RiskType;
import java.math.BigDecimal;

/**
 * Risk strategy interface
 */
public interface IRiskCalculationStrategy {

     /**
      * Calculates premium for riskType
      *
      * @param policy object
      * @param riskType
      * @return calculated premium for specified riskType
      */
     BigDecimal calculatePremium(final Policy policy, final RiskType riskType);


     /**
      * Calculates SumInsured specified policy and riskType
      *
      * @param policy object
      * @param riskType
      * @return calculated premium specified policy and riskType
      */
     default BigDecimal calculateSumInsured(final Policy policy, final RiskType riskType){
          return policy.getPolicyObjects().stream().flatMap(policyObject -> policyObject.getSubObjects().stream()).filter(policySubObject -> policySubObject.getRiskType() == riskType).map(PolicySubObject::getSumInsured).reduce(BigDecimal.ZERO, BigDecimal::add);
     }

}
