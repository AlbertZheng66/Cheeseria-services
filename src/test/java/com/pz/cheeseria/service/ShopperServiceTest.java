package com.pz.cheeseria.service;

import com.pz.cheeseria.domains.CheeseVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopperServiceTest {

    @Autowired
    private ShopperService shopperService;

    @Test
    void listPopular() {
        List<CheeseVO> results = shopperService.listPopular(0, 2);
        assertNotNull(results, "Cheese should not be null");
        assertEquals(2, results.size(), "Check result size");
        CheeseVO result0 = results.get(0);
        assertNotNull(result0.getUuid(), "UUID cannot be null");
        assertNotNull(result0.getPrice(), "Price cannot be null");
        assertTrue(result0.getPrice().compareTo(BigDecimal.ZERO) >= 0, "Price cannot be negative");
        // TODO: CHECK OTHER FIELDS
    }
}