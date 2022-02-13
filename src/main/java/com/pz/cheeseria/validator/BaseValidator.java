package com.pz.cheeseria.validator;


import com.pz.cheeseria.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class BaseValidator {
    /**
     * TODO: Should be combined with the same method in ShopperVa
     * @param startIndex
     * @param batchSize
     */
    public void batchingRange(int startIndex, int batchSize) {
        if (startIndex < 0) {
            throw new ValidationException("startIndex.notNegative", "Start Index must be zero or positive");
        }
        if (batchSize <= 0) {
            throw new ValidationException("batchSize.mustPositive", "Batch Size must be positive");
        }
    }
}
