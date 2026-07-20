package vn.edu.fpt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.edu.fpt.model.Room;

import org.springframework.data.jpa.repository.Query;
import vn.edu.fpt.model.constant.RoomStatus;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.roomNumber LIKE %:keyword% " +
            "AND (:status IS NULL OR r.status = :status)")
    Page<Room> searchAndFilterRooms(@Param("keyword") String keyword,
                                    @Param("status") RoomStatus status,
                                    Pageable pageable);
}
