/**
 * $Id$
 * @author magnolin@scytl.net
 * @date   Dec 14, 2018 3:19:02 PM
 *
 * Copyright (C) 2018 Amaris
 *
 * All rights reserved.
 *
 */
package com.amaris.futbol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.amaris.futbol.domain.Event;
import com.amaris.futbol.repository.IGenericDAO;

/**
 *
 */
public class EventService extends GenericServiceImple<Event> {

    @Autowired
    public EventService(
            @Qualifier("EventDao") final IGenericDAO<Event, Long> genericDao) {
        setGenericDAO(genericDao);
    }
}
