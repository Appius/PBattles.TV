package com.pbattles.strategy;

import com.google.common.collect.Sets;
import com.pbattles.entity.Room;
import com.pbattles.entity.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by Nazar_Sheremeta on 3/25/14.
 */
public class DuplicateValidator implements RoomValidator{
    @Override
    public boolean validate(Room room) {
        List<UserInfo> roomUsers = room.getCurrentUsers();
        Set<UserInfo> uniqueRoomUsers = Sets.newHashSet(roomUsers);
        return roomUsers.size() == uniqueRoomUsers.size();
    }
}
