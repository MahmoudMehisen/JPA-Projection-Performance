package com.mehisen.jpaperformance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
//    List<UserEntity> findAllByCity(String city);
    List<UserEmailAndCityProjection> findAllByCity(String city);

}
