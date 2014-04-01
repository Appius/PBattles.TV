package com.pbattles.entity;

import java.util.List;

/**
 * Created by Nazar_Sheremeta on 3/25/14.
 */
public class Room {

    private List<UserInfo> currentUsers;
    private int capacity;

    public Room() {
    }

    public Room(List<UserInfo> currentUsers, int capacity) {
        this.currentUsers = currentUsers;
        this.capacity = capacity;
    }

    public List<UserInfo> getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(List<UserInfo> currentUsers) {
        this.currentUsers = currentUsers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (capacity != room.capacity) return false;
        if (!currentUsers.equals(room.currentUsers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currentUsers.hashCode();
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "currentUsers=" + currentUsers +
                ", capacity=" + capacity +
                '}';
    }
}
