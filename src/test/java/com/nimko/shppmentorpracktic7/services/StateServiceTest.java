package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import com.nimko.shppmentorpracktic7.utils.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StateServiceTest {
    ToDoEntity plannedEntity;
    ToDoEntity workEntity;
    ToDoEntity doneEntity;
    ToDoEntity cancelEntity;
    StateService stateService;
    @BeforeEach
    void setUp(){
         plannedEntity = new ToDoEntity("qwerty",
                LocalDateTime.of(2023,2,12,12,1),
                State.PLANNED );
         workEntity = new ToDoEntity("qwerty",
                LocalDateTime.of(2023,2,12,12,1),
                State.WORK_IN_PROGRESS );
         doneEntity = new ToDoEntity("qwerty",
                LocalDateTime.of(2023,2,12,12,1),
                State.DONE );
         cancelEntity = new ToDoEntity("qwerty",
                LocalDateTime.of(2023,2,12,12,1),
                State.CANCELED );
         stateService = new StateService();
    }


    @Test
    void getUpdatePlannedToWork() {
        assertEquals(State.WORK_IN_PROGRESS,
                stateService.getUpdate(plannedEntity, workEntity).getState());
    }
    @Test
    void getUpdateWorkToDone() {
        assertEquals(State.DONE,
                stateService.getUpdate(workEntity,doneEntity).getState());
    }

    @Test
    void getUpdatePlannedToCancel() {
        assertEquals(State.CANCELED,
                stateService.getUpdate(plannedEntity,cancelEntity).getState());
    }
    @Test
    void getUpdateWorkToCancel() {
        assertEquals(State.CANCELED,
                stateService.getUpdate(workEntity,cancelEntity).getState());
    }

    @Test
    void getUpdateDoneToCancel() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(doneEntity, cancelEntity));
    }

    @Test
    void getUpdatePlannedToDone() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(plannedEntity, doneEntity));
    }
    @Test
    void getUpdateWorkToPlanned() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(workEntity, plannedEntity));
    }
    @Test
    void getUpdateDoneToPlanned() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(doneEntity, plannedEntity));
    }

    @Test
    void getUpdateDoneToWork() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(doneEntity, workEntity));
    }

    @Test
    void getUpdateCancelToPlanned() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(cancelEntity, plannedEntity));
    }

    @Test
    void getUpdateCancelToWork() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(cancelEntity, workEntity));
    }

    @Test
    void getUpdateCancelToDone() {
        assertThrows(NoSuchElementException.class,() ->
                stateService.getUpdate(cancelEntity, doneEntity));
    }
}