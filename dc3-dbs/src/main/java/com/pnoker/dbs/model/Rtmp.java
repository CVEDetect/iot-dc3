package com.pnoker.dbs.model;

import lombok.Data;

/**
 * <p>Copyright(c) 2018. Pnoker All Rights Reserved.
 * <p>Author     : Pnoker
 * <p>Email      : pnokers@gmail.com
 * <p>Description: Rtmp 信息实体类
 */
@Data
public class Rtmp {
    private long id;
    private String rtspUrl;
    private String rtmpUrl;
    private short videoType;
}
