package top.mcso.sms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mcso.sms.entity.Announcement;
import top.mcso.sms.service.AnnouncementServiceImpl;

@SpringBootTest
class StudentManagementSystemApplicationTests {

    @Autowired
    private AnnouncementServiceImpl announcementServiceImpl;

    @Test
    void contextLoads() {
        Announcement test = new Announcement("1", "test");
        announcementServiceImpl.addAnnouncement(test);
    }

}
