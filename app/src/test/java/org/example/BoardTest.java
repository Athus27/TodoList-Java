package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTest {
    @Test
    public void testAddTask() {
        //given
        Board board = new Board(1, 1, "Test Board", "This is a test board");
        Task task = new Task(1, 1, "Test Task", "This is a test task", "ToDo", "Test Category", "2024-06-30");

        //when
        board.addTask(task);

        //then
        assertEquals(1, board.getTasks().size());
        assertEquals(task, board.getTasks().get(0));
    }

    @Test
    public void testRemoveTask() {
        //given
        Board board = new Board(1, 1, "Test Board", "This is a test board");
        Task task = new Task(1, 1, "Test Task", "This is a test task", "ToDo", "Test Category", "2024-06-30");
        board.addTask(task);

        //when
        board.removeTask(task);

        //then
        assertEquals(0, board.getTasks().size());
    }

    @Test
    public void testMoveTaskFromTodoToDoing() {
        //given
        Board board = new Board(1, 1, "Test Board", "This is a test board");
        Task task = new Task(1, 1, "Test Task", "This is a test task", "ToDo", "Test Category", "2024-06-30");
        board.addTask(task);

        //when
        board.moveTask(task);

        //then
        assertEquals("Doing", task.getSection());
    }

    @Test
    public void testMoveTaskFromDoingToDone() {
        //given
        Board board = new Board(1, 1, "Test Board", "This is a test board");
        Task task = new Task(1, 1, "Test Task", "This is a test task", "2024-06-30", "Test Category", "Doing");
        board.addTask(task);

        //when
        board.moveTask(task);

        //then
        assertEquals("Done", task.getSection());
    }

    @Test
    public void editTask() {
        Board board = new Board(1, 1, "Test Board", "This is a test board");
        Task task = new Task(1, 1, "Test Task", "This is a test task", "2024-06-30", "Test Category", "Doing");
        board.addTask(task);



    }
}