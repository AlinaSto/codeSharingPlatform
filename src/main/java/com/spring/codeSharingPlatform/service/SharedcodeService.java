package com.spring.codeSharingPlatform.service;

import com.spring.codeSharingPlatform.dto.SharedCodeResponseDTO;
import com.spring.codeSharingPlatform.model.SharedCode;
import com.spring.codeSharingPlatform.repository.SharedCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class SharedcodeService {
    private SharedCodeRepository sharedCodeRepository;

    @Autowired
    public SharedcodeService(SharedCodeRepository sharedCodeRepository) {
        this.sharedCodeRepository = sharedCodeRepository;
    }

    public SharedCode addSharedCode(SharedCode sharedCode) {
        sharedCode.setCreatedDateTime(LocalDateTime.now());
        return sharedCodeRepository.save(sharedCode);
    }

    public SharedCodeResponseDTO getSharedCode(Long codeId) {
        SharedCode foundSharedCode = sharedCodeRepository.findById(codeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "shared code not found"));
       if (foundSharedCode.isPublic()){
           return new SharedCodeResponseDTO(foundSharedCode,0L,false);
       }
        if (foundSharedCode.isExpired()) {
            sharedCodeRepository.delete(foundSharedCode);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "shared code cannot be viewed anymore");
        }
        foundSharedCode.setViews(foundSharedCode.getViews() - 1);
        SharedCodeResponseDTO sharedCodeResponseDTO = new SharedCodeResponseDTO(foundSharedCode, foundSharedCode.getTimeLeft(), true);
        sharedCodeRepository.save(foundSharedCode);
        return sharedCodeResponseDTO;
    }
}
