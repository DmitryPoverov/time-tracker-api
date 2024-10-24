package by.poverov.repository;

import by.poverov.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByUserId(Long userId);

    List<Record> findByProjectId(Long projectId);
}
