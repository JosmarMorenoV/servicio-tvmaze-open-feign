package com.tvmaze.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvmaze.modelo.ShowCache;

public interface ShowCacheRepository extends MongoRepository<ShowCache, Long> {

}
