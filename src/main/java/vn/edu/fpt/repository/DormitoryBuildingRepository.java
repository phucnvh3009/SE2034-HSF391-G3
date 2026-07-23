package vn.edu.fpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.model.DormitoryBuilding;

import java.util.Optional;

@Repository
public interface DormitoryBuildingRepository extends JpaRepository<DormitoryBuilding, Long> {
//    @Query("SELECT DISTINCT b FROM DormitoryBuilding b " +
//            "LEFT JOIN FETCH b.floors f " +
//            "LEFT JOIN FETCH f.rooms r " +
//            "LEFT JOIN FETCH r.beds " +
//            "WHERE b.id = :buildingId")
//    Optional<DormitoryBuilding> findBuildingWithAllDetails(@Param("buildingId") Long buildingId);
}
