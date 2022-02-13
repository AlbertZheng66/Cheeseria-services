package com.pz.cheeseria.service;


import com.pz.cheeseria.Main;
import com.pz.cheeseria.controller.ShopperController;
import com.pz.cheeseria.domains.CheeseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
// If we need to access DB, this annotation should be uncommented
// @Transactional(rollbackOn = Exception.class)
public class ShopperService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopperService.class);

    public List<CheeseVO> listPopular(int startIndex, int batchSize) {
        LOGGER.info("Listing popular cheeses...");
        List<CheeseVO> cheeses = Arrays.asList(new CheeseVO("1", "Cheese1",
                        Arrays.asList("https://en.wikipedia.org/wiki/Red_Hawk_cheese#/media/File:Cowgirl_Creamery_Point_Reyes_-_Red_Hawk_cheese.jpg"),
                        BigDecimal.valueOf(5.99), "Yellow"),
                new CheeseVO("2", "Cheese2", Arrays.asList("url"), BigDecimal.valueOf(8.99), "Paint"),
                new CheeseVO("3", "Cheese3", Arrays.asList("url"), BigDecimal.valueOf(3.99), "Orange"));
        if (startIndex >= cheeses.size()) {
            return Collections.emptyList();
        } else {
            return cheeses.subList(startIndex, Math.min(startIndex + batchSize, cheeses.size()));
        }
    }
}
