package com.spring.codeSharingPlatform.controller;

import com.spring.codeSharingPlatform.dto.SharedCodeResponseDTO;
import com.spring.codeSharingPlatform.model.SharedCode;
import com.spring.codeSharingPlatform.service.SharedcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class SharedCodeController {

    private SharedcodeService sharedcodeService;

    @Autowired
    public SharedCodeController(SharedcodeService sharedcodeService) {
        this.sharedcodeService = sharedcodeService;
    }

    @PostMapping("/add")
    public SharedCode addSharedCode(@RequestBody SharedCode sharedCode) {
        return sharedcodeService.addSharedCode(sharedCode);
    }

    @GetMapping("/{codeId}")
    public SharedCodeResponseDTO getSharedCode(@PathVariable Long codeId) {
        return sharedcodeService.getSharedCode(codeId);
    }
}
