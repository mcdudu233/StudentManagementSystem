package top.mcso.sms.service;

import top.mcso.sms.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    public int addAnnouncement(Announcement announcement);

    public int removeAnnouncementById(String id);

    public int updateAnnouncement(Announcement announcement);

    public Announcement getAnnouncementById(String id);

    public List<Announcement> getAllAnnouncements();


}
