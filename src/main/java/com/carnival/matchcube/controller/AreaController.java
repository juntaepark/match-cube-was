package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.AreaDTO;
import com.carnival.matchcube.service.AreaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public ResponseEntity getArea() throws Exception {
        return areaService.getArea();

    }

    @GetMapping("/si-gun-gu")
    public ResponseEntity getUnderArea(AreaDTO areaDTO) throws Exception {
        return areaService.getUnderArea(areaDTO);
    }
}