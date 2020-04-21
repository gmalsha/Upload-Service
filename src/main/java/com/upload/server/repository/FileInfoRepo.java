package com.upload.server.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.upload.server.model.FileInfo;
import reactor.core.publisher.Flux;

public interface FileInfoRepo extends ReactiveMongoRepository<FileInfo, Integer> {
    @Query("{ 'zipFileName': ?0 }")
    Flux<FileInfo> findByZipFileName(String zipFileName);
}
