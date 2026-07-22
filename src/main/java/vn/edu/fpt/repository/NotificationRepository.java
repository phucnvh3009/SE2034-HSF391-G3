package vn.edu.fpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.model.Notification;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT n FROM Notification n WHERE " +
           "n.targetType = 'ALL' " +
           "OR (n.targetType = 'BUILDING' AND n.targetBuilding.id = :buildingId) " +
           "OR (n.targetType = 'STUDENT' AND n.targetStudent.id = :studentId) " +
           "ORDER BY n.createdAt DESC")
    List<Notification> findNotificationsForUser(@Param("buildingId") Long buildingId, @Param("studentId") Long studentId);
}
