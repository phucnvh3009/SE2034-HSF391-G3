package vn.edu.fpt.service;

import vn.edu.fpt.dto.NotificationDTO;
import vn.edu.fpt.dto.response.domstaff.Notification4StaffDto;
import vn.edu.fpt.model.User;

import java.util.List;

public interface NotificationService {

    List<NotificationDTO> getNotificationsForUser(User user);
    List<NotificationDTO> getNotificationsByTypeAndUser(String type, User user);
    void sendNotification(Notification4StaffDto dto, User sender);
    long countUnread(User user);
}
