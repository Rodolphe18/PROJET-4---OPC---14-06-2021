package com.francotte.mareunion.ui.app.events;

import com.francotte.mareunion.ui.app.model.Meeting;

public class DeleteMeetingEvent {

    public Meeting mMeeting;

    public DeleteMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
    }
}


