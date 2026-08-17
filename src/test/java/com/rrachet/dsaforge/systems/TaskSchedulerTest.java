package com.rrachet.dsaforge.systems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {
    @Test void higherPriorityRunsFirst() {
        TaskScheduler<String> scheduler = new TaskScheduler<>();
        scheduler.submit("normal", 1);
        scheduler.submit("urgent", 10);
        scheduler.submit("normal-2", 1);
        assertEquals("urgent", scheduler.next());
        assertEquals("normal", scheduler.next());
        assertEquals("normal-2", scheduler.next());
    }
}
