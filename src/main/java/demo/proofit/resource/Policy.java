package demo.proofit.resource;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Top level class for storing Policy data
 */
@Getter
@Builder
@Valid
public class Policy {

    @NotNull
    @Size(max = 100)
    private String policyNumber;

    @NotNull
    private PolicyStatus status;

    @NotNull
    private List<PolicyObject> policyObjects;

}
