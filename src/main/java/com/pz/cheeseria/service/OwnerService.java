package com.pz.cheeseria.service;


import com.pz.cheeseria.domains.CheeseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
// If we need to access DB, this annotation should be uncommented
// @Transactional(rollbackOn = Exception.class)
public class OwnerService {

    private final static List<CheeseVO> savedCheeses = Collections.synchronizedList(new ArrayList<>());

    public List<CheeseVO> list(int startIndex, int batchSize) {
        if (startIndex >= savedCheeses.size()) {
            return Collections.emptyList();
        } else {
            return savedCheeses.subList(startIndex, Math.min(startIndex + batchSize, savedCheeses.size()));
        }
    }

    public CheeseVO save(CheeseVO cheeseVO) {
        if (StringUtils.isEmpty(cheeseVO.getUuid())) {
            cheeseVO.setUuid(UUID.randomUUID().toString());
        }
        savedCheeses.add(cheeseVO);
        return cheeseVO;
    }

    public boolean delete(String uuid) {
        Optional<CheeseVO> cheeseOpt = savedCheeses.stream().filter(c -> Objects.equals(uuid, c.getUuid())).findFirst();
        if (cheeseOpt.isPresent()) {
            savedCheeses.remove(cheeseOpt.get());
            return true;
        } else {
            return false;
        }
    }

    public CheeseVO get(String uuid) {
        Optional<CheeseVO> cheeseOpt = savedCheeses.stream().filter(c -> Objects.equals(uuid, c.getUuid())).findFirst();
        if (cheeseOpt.isPresent()) {
            return cheeseOpt.get();
        }
        return null;
    }

    public List<CheeseVO> getSavedCheeses() {
        return savedCheeses;
    }


}
