package hsf302.mvc.demothymeleaf.controller;



import hsf302.mvc.demothymeleaf.model.Notification;
import hsf302.mvc.demothymeleaf.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationRepository repo;

    @PostMapping("/submit-order")
    public String submitOrder() {
        Notification noti = new Notification();
        noti.setMessage("Đơn hàng đã được đặt thành công!");


        // Đảm bảo không có trường nào bị null gây lỗi
        repo.save(noti);

        messagingTemplate.convertAndSend("/topic/notifications", noti.getMessage());

        return "redirect:/notification";  // quay về trang thông báo
    }

    @GetMapping("/notification")
    public String notificationPage(Model model) {
        model.addAttribute("notifications", repo.findAllByOrderByCreatedAtDesc());
        return "notification";
    }
}

