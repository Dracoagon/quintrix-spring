package com.quintrix.jfs.quintrixspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quintrix.jfs.quintrixspring.models.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer> {

}
