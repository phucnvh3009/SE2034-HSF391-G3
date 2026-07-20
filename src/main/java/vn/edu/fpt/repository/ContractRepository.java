package vn.edu.fpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.model.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    
    @Query("SELECT c FROM Contract c JOIN FETCH c.student s LEFT JOIN FETCH s.studentProfile p WHERE c.bed.room.id = :roomId AND c.status = 'ACTIVE'")
    List<Contract> findActiveContractsByRoomId(@Param("roomId") Long roomId);
}
