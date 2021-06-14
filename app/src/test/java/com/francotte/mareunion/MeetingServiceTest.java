package com.francotte.mareunion;

import com.francotte.mareunion.ui.app.DI.DI;
import com.francotte.mareunion.ui.app.model.Meeting;
import com.francotte.mareunion.ui.app.service.DummyMeetingGenerator;
import com.francotte.mareunion.ui.app.service.MeetingApiService;

import org.junit.Test;

import static org.junit.Assert.*;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
public class MeetingServiceTest {

    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetingsWithSuccess() {
        List<Meeting> meetings = service.getMeetings();
        List<Meeting> expectedMeetings = DummyMeetingGenerator.DUMMY_MEETINGS;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder((expectedMeetings.toArray())));
    }

    @Test
    public void deleteMeetingWithSuccess() {
        Meeting meetingToDelete = service.getMeetings().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetings().contains(meetingToDelete));
    }

    @Test
    public void createMeetingWithSuccess() {
        Meeting meetingToCreate = new Meeting(6, "anniversaire", "rodolphe@lamzone.com", "Salle G", 18, 30);
        service.createMeeting(meetingToCreate);
        assertTrue(service.getMeetings().contains(meetingToCreate));
    }

    @Test
    public void filterMeetingByRoomWithSuccess() {
        ArrayList<String> rooms = new ArrayList<>();
        rooms.add("Salle A");
        List<Meeting> expectedMeetings = service.filterMeetingByRoom("Salle A");
        assertEquals(1, expectedMeetings.size());
    }

    @Test
    public void filterMeetingByTimeWithSuccess() {
        List<Meeting> expectedMeetings = service.filterMeetingByTime(14, 30);
        assertEquals(1, expectedMeetings.size());
    }

}