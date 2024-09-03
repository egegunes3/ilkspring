package com.huseyinAbi.springDBDeneme.repository;

import com.huseyinAbi.springDBDeneme.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILectureRepository extends JpaRepository<Lecture, Integer> {
}
