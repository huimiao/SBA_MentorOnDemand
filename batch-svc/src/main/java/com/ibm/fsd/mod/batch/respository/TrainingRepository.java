package com.ibm.fsd.mod.batch.respository;

import com.ibm.fsd.mod.batch.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query("select DISTINCT t from Training t left join t.studentTrainings as s where t.startDate <= CURRENT_DATE and t.endDate >= CURRENT_DATE")
    List<Training> findAllMentors();
}
