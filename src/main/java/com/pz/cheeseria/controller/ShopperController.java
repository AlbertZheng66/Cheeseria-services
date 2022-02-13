package com.pz.cheeseria.controller;


import com.pz.cheeseria.domains.CheeseVO;
import com.pz.cheeseria.service.ShopperService;
import com.pz.cheeseria.validator.ShopperValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShopperController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopperController.class);

    @Autowired
    private ShopperService shopperService;

    @Autowired
    private ShopperValidator shopperValidator;

    @RequestMapping(value = "/popular/{startIndex}/{batchSize}", method = RequestMethod.GET)
    public List<CheeseVO> listPopular(@PathVariable int startIndex, @PathVariable int batchSize) {
        LOGGER.info("Retrieving this most popular cheeses from [{}] to [{}]", startIndex, batchSize);
        // TODO: We might do authorization and authentication here
        // TODO: Sometimes, we do caching here
        shopperValidator.batchingRange(startIndex, batchSize);
        List<CheeseVO> cheeses = shopperService.listPopular(startIndex, batchSize);
        LOGGER.info("Found this most popular cheeses: {}", cheeses);
        return cheeses;
    }

}
