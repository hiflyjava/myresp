package com.pg.mapper;

import com.pg.bean.Hr;
import com.pg.bean.MsgContent;
import com.pg.bean.SysMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by pg on 2018/2/2.
 */
public interface SysMsgMapper {

    int sendMsg(MsgContent msg);

    int addMsg2AllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);

    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("hrid") Long hrid);

    int markRead(@Param("flag") Long flag, @Param("hrid") Long hrid);
}
