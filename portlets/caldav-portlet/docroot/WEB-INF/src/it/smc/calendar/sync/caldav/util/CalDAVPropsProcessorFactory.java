/**
 * Copyright (c) 2013 SMC Treviso Srl. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.smc.calendar.sync.caldav.util;

import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.xml.Element;

import it.smc.calendar.sync.caldav.CalendarBookingPropsProcessor;
import it.smc.calendar.sync.caldav.CalendarBookingResourceImpl;
import it.smc.calendar.sync.caldav.CalendarPropsProcessor;
import it.smc.calendar.sync.caldav.CalendarResourcePropsProcessor;
import it.smc.calendar.sync.caldav.CalendarResourceResourceImpl;
import it.smc.calendar.sync.caldav.PrincipalPropsProcessor;
import it.smc.calendar.sync.caldav.PropsProcessor;
import it.smc.calendar.sync.caldav.UserResourceImpl;
public class CalDAVPropsProcessorFactory {

	public static PropsProcessor create(
			WebDAVRequest webDAVRequest, Resource resource,
			Element rootElement) {

		if (resource instanceof CalendarResourceResourceImpl) {
			return new CalendarResourcePropsProcessor(
				webDAVRequest, resource, rootElement);
		}
		else if (resource instanceof UserResourceImpl) {
			return new PrincipalPropsProcessor(
				webDAVRequest, resource, rootElement);
		}
		else if (resource instanceof CalendarBookingResourceImpl) {
			return new CalendarBookingPropsProcessor(
				webDAVRequest, resource, rootElement);
		}
		else {
			return new CalendarPropsProcessor(
				webDAVRequest, resource, rootElement);
		}
	}

}