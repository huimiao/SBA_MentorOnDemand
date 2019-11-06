package com.ibm.fsd.mod.batch.respository;

import com.ibm.fsd.mod.batch.model.StudentTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface StudentTrainingRepository extends JpaRepository<StudentTraining, Long> {
    @Modifying
    @Query(nativeQuery = true,
            value = "update student_training set amount_received = :amount , last_updated_by = :updatedBy,last_updated_timestamp=CURRENT_TIMESTAMP where cid = :id and amount_received != :amount")
    int updatePayAmount(Long id, BigDecimal amount, String updatedBy);
}
