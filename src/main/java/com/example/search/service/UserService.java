package com.example.search.service;

import com.example.search.entity.FrogEntity;
import com.example.search.entity.FrogUserDocument;
import com.example.search.repo.FrogUserElasticRepository;
import com.example.search.repo.FrogUserEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {


    private final FrogUserElasticRepository frogUserElasticRepository;
    private final FrogUserEntityRepository frogUserEntityRepository;

    public Iterable<FrogUserDocument> getAllUsers() {
        return frogUserElasticRepository.findAll();
    }

    public void loadAllUsers() {
        List<FrogEntity> all = frogUserEntityRepository.findAll();
        List<FrogUserDocument> collect = all.stream()
                .map(e -> new FrogUserDocument(String.valueOf(e.getId()), e.getUser_name()))
                .collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        frogUserElasticRepository.saveAll(collect);
        long endTime = System.currentTimeMillis();

        log.info("save took {} ms", endTime - startTime);
    }
}
