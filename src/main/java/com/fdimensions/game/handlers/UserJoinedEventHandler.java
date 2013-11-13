package com.fdimensions.game.handlers;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class UserJoinedEventHandler extends BaseServerEventHandler {
	@Override
	public void handleServerEvent(ISFSEvent event) throws SFSException
	{
		Room room = (Room) event.getParameter(SFSEventParam.ROOM);	
        User user = (User) event.getParameter(SFSEventParam.USER);

        trace("Dimensions: user " + user.getName() + " entered the game room '" + room.getName() + "' - game room id: " + room.getId());
	}
}