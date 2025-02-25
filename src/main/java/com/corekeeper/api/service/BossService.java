package com.corekeeper.api.service;

import com.corekeeper.api.model.Boss;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class BossService {

    private List<Boss> bosses;

    @PostConstruct
    private void init() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Boss>> typeReference = new TypeReference<>() {};
        InputStream inputStream = getClass().getResourceAsStream("/data/bosses.json");

        try {
            bosses = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load bosses data", e);
        }
    }

    public List<Boss> getAllBosses() {
        return bosses;
    }

    public Boss getBossById(Long id) {
        return bosses.stream()
                .filter(boss -> boss.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
