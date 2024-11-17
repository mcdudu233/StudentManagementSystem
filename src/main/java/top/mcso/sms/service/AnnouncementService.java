package top.mcso.sms.service;

import top.mcso.sms.entity.Announcement;

import java.util.List;


public interface AnnouncementService {
    int addAnnouncement(Announcement announcement);

    int removeAnnouncementById(String id);

    int updateAnnouncement(Announcement announcement);

    Announcement getAnnouncementById(String id);

    List<Announcement> getAllAnnouncements();


}
