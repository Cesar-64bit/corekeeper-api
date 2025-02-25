package com.corekeeper.api.controller;

import com.corekeeper.api.model.Boss;
import com.corekeeper.api.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bosses")
@CrossOrigin(origins = "http://localhost:4200")
public class BossesController {

    @Autowired
    private BossService bossService;

    @GetMapping
    public List<Boss> getBosses() {
        return bossService.getAllBosses();
    }

    @GetMapping("/{id}")
    public Boss getBossById(@PathVariable Long id) {
        return bossService.getBossById(id);
    }
}
