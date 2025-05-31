package hsf302.mvc.demothymeleaf.repository;

import hsf302.mvc.demothymeleaf.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Additional query methods can be defined here if needed
    List<Notification> findAllByOrderByCreatedAtDesc();

}
