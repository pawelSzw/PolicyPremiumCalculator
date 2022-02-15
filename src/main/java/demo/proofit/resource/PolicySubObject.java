package demo.proofit.resource;

import lombok.Builder;
import lombok.Getter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Policy sub-objects can be related only to one policy object
 *
 */
@Valid
@Getter
@Builder
public class PolicySubObject {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private BigDecimal sumInsured;

    @NotNull
    private RiskType riskType;

}
