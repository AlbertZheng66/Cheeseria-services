package com.pz.cheeseria.controller;

import com.pz.cheeseria.domains.CheeseVO;
import com.pz.cheeseria.service.OwnerService;
import com.pz.cheeseria.validator.OwnerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopperController.class);

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerValidator ownerValidator;

    @RequestMapping(value = "/cheeses/{startIndex}/{batchSize}", method = RequestMethod.GET)
    public List<CheeseVO> listCheeses(@PathVariable int startIndex, @PathVariable int batchSize) {
        LOGGER.info("Retrieving cheeses with pagination parameters from [{}] to [{}]", startIndex, batchSize);
        // TODO: We might do authorization and authentication here
        ownerValidator.batchingRange(startIndex, batchSize);
        List<CheeseVO> cheeses = ownerService.list(startIndex, batchSize);
        LOGGER.info("Found cheeses: {}", cheeses);
        return cheeses;
    }

    @RequestMapping(value = "/cheese/{cheeseUuid}", method = RequestMethod.GET)
    public CheeseVO getCheese(@PathVariable String cheeseUuid) {
        LOGGER.info("Retrieving cheese with uuid: {}", cheeseUuid);
        // TODO: We might do authorization and authentication here
        ownerValidator.owningCheese(cheeseUuid);
        CheeseVO cheese = ownerService.get(cheeseUuid);
        LOGGER.info("Found cheese: {}", cheese);
        return cheese;
    }

    @RequestMapping(value = "/cheese/{cheeseUuid}", method = RequestMethod.DELETE)
    public Boolean deleteCheese(@PathVariable String cheeseUuid) {
        LOGGER.info("Deleting result with uuid: {}", cheeseUuid);
        // TODO: We might do authorization and authentication here
        ownerValidator.owningCheese(cheeseUuid);
        boolean result = ownerService.delete(cheeseUuid);
        LOGGER.info("Deleted result: {}", result);
        return result;
    }

    @RequestMapping(value = "/cheese", method = RequestMethod.PUT)
    public CheeseVO addCheese(@RequestBody CheeseVO cheeseVO) {
        LOGGER.info("Adding cheese: {}", cheeseVO);
        // TODO: We might do authorization and authentication here
        ownerValidator.validateAddingCheese(cheeseVO);
        CheeseVO result = ownerService.save(cheeseVO);
        LOGGER.info("Added cheese: {}", result);
        return result;
    }

    @RequestMapping(value = "/cheese", method = RequestMethod.PATCH)
    public CheeseVO updateCheese(@RequestBody CheeseVO cheeseVO) {
        LOGGER.info("Updating cheese: {}", cheeseVO);
        // TODO: We might do authorization and authentication here
        ownerValidator.validateUpdatingCheese(cheeseVO);
        CheeseVO result = ownerService.save(cheeseVO);
        LOGGER.info("Updated cheese: {}", result);
        return result;
    }

}
