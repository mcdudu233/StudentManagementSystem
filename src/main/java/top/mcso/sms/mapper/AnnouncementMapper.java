package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Announcement;

import java.util.List;

@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {
    // 插入公告信息
    @Insert("insert into announcement (id, announcement) values (#{id}, #{announcement})")
    boolean insertAnnouncement(Announcement announcement);

    // 根据ID删除公告
    @Delete("delete from announcement where id = #{id}")
    boolean deleteAnnouncementById(@Param("id") String id);

    // 更新公告信息
    @Update("update announcement set announcement = #{announcement} where id = #{id}")
    boolean updateAnnouncement(Announcement announcement);

    // 根据ID查询公告
    @Select("select * from announcement where id = #{id}")
    Announcement selectAnnouncementById(@Param("id") String id);

    // 查询所有公告
    @Select("select * from announcement")
    List<Announcement> selectAllAnnouncements();
}
