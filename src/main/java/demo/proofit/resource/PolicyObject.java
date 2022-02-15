package demo.proofit.resource;

import lombok.Builder;
import lombok.Getter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Policy objects can have multiple sub-objects and can be related only to one policy
 */
@Getter
@Builder
@Valid
public class PolicyObject {
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private List<PolicySubObject> subObjects;
}
