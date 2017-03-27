/*
 * OmdsEvent.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.measureCore.common.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-07-20
 */
public class OmdsEvent extends GenericModel {

    private Long eventid;

    public Long getEventid() {
        return eventid;
    }
    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }
}