/*
 * Copyright 2018-2020 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dc3.common.bean.driver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author pnoker
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointValue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    private Long id;
    private Long deviceId;
    private Long pointId;

    private String rawValue;
    private String value;
    private List<PointValue> children;

    @Transient
    @JsonIgnore
    private int timeOut = 15;
    @Transient
    @JsonIgnore
    private TimeUnit timeUnit = TimeUnit.MINUTES;

    private Boolean multi = false;
    private Long originTime;
    private Long createTime;

    public PointValue(Long pointId, String rawValue, String value) {
        this.pointId = pointId;
        this.rawValue = rawValue;
        this.value = value;
    }

    public PointValue(Long deviceId, Long pointId, String rawValue, String value) {
        this.deviceId = deviceId;
        this.pointId = pointId;
        this.rawValue = rawValue;
        this.value = value;
        this.originTime = System.currentTimeMillis();
    }

    public PointValue(Long deviceId, Long pointId, String rawValue, String value, int timeOut, TimeUnit timeUnit) {
        this.deviceId = deviceId;
        this.pointId = pointId;
        this.rawValue = rawValue;
        this.value = value;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.originTime = System.currentTimeMillis();
    }

    public PointValue(Long deviceId, List<PointValue> children) {
        this.deviceId = deviceId;
        this.children = children;
        this.originTime = System.currentTimeMillis();
    }

    public PointValue(Long deviceId, List<PointValue> children, int timeOut, TimeUnit timeUnit) {
        this.deviceId = deviceId;
        this.children = children;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.originTime = System.currentTimeMillis();
    }
}
