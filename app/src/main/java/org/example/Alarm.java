package org.example;


import java.time.LocalDateTime;
import java.util.Iterator;

public class Alarm implements Runnable {
    private final Board board;

    private final long delay;


    public Alarm(Board board, long delay) {
        this.delay = delay;
        this.board = board;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            checkAlarms();
            waitForAlarm();
        }
    }

    private void checkAlarms() {
        for (Task task : board.getTasks()) {
            if (task.getSection().equals("Done")) {
                continue;
            }

            Iterator<LocalDateTime> iterator = task.getAlarmTimes().iterator();

            while (iterator.hasNext()) {
                LocalDateTime alarmTime = iterator.next();

                if (!LocalDateTime.now().isBefore(alarmTime)) {
                    trigger(task, alarmTime);
                    iterator.remove();
                }
            }
        }
    }

    /**
     * trigger: dispara o alarme para a tarefa especificada, exibindo informações relevantes no console.
     */
    private void trigger(Task task, LocalDateTime alarmTime) {
        System.out.println("\n=== ALARME DE TAREFA ===");
        System.out.println("Tarefa: " + task.getTitle());
        System.out.println("Descricao: " + task.getDescription());
        System.out.println("Prioridade: " + task.getPriority());
        System.out.println("Termina em: " + task.getTarget_data());
        System.out.println("Alarme configurado para: " + alarmTime);
        System.out.println("========================");
    }

    private void waitForAlarm() {
        try {
            //Thread.sleep pausa a execução da thread atual por um período de tempo especificado em milissegundos.
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Alarme interrompido");
            return;
        }
        // esperar
    }

}
