package top.mcso.sms.service;

import top.mcso.sms.entity.Announcement;

import java.util.List;


public interface AnnouncementService {
    boolean addAnnouncement(Announcement announcement);

    boolean removeAnnouncementById(String id);

    boolean updateAnnouncement(Announcement announcement);

    Announcement getAnnouncementById(String id);

    List<Announcement> getAllAnnouncements();


}
