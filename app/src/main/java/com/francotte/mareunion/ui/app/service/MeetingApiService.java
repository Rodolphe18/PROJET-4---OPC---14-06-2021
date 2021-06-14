package com.francotte.mareunion.ui.app.service;

import com.francotte.mareunion.ui.app.model.Meeting;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeeting(Meeting meeting);

    void createMeeting(Meeting meeting);

    List<Meeting> filterMeetingByRoom(String meetingRoom);

    List<Meeting> filterMeetingByTime(int startHourOfMeeting, int startMinutesOfMeeting);
}


