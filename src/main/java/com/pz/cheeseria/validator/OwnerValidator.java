package com.pz.cheeseria.validator;

import com.pz.cheeseria.domains.CheeseVO;
import com.pz.cheeseria.exceptions.ValidationException;
import com.pz.cheeseria.service.OwnerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class OwnerValidator extends BaseValidator {

    @Autowired
    private OwnerService ownerService;

    public void owningCheese(String cheeseUuid) {
        Optional<CheeseVO> cheeseOpt = ownerService.getSavedCheeses().stream()
                .filter(c -> Objects.equals(c.getUuid(), cheeseUuid))
                .findFirst();
        if (!cheeseOpt.isPresent()) {
            throw new ValidationException("cheese.notFound", "Cheese cannot be found");
        }
    }

    public void validateAddingCheese(CheeseVO cheeseVO) {
        if (StringUtils.isNotEmpty(cheeseVO.getUuid())) {
            throw new ValidationException("cheese.uuid.mustEmpty", "Cheese UUID must be empty");
        }
        //TODO: CHECK ALL OTHER FIELDS
    }

    public void validateUpdatingCheese(CheeseVO cheeseVO) {
        owningCheese(cheeseVO.getUuid());
        //TODO: CHECK ALL OTHER FIELDS
    }
}
