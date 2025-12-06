package TimeDateTools;

import utils.InputHelper;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
public class Stopwatch {

        private long startTime;
        private long elapsedTime;
        private boolean running;

        public void run() {
            System.out.println("\n--- Stopwatch ---");
            System.out.println("Commands: s = start/stop, r = reset, e = exit");

            try {
                while (true) {
                    if (System.in.available() > 0) { // check if user typed something
                        char command = (char) System.in.read();
                        switch (command) {
                            case 's', 'S' -> {
                                if (running) stop();
                                else start();
                            }
                            case 'r', 'R' -> reset();
                            case 'e', 'E' -> {
                                System.out.println("\nExiting...");
                                return;
                            }
                        }
                    }

                    if (running) {
                        long now = System.currentTimeMillis();
                        long time = elapsedTime + (now - startTime);
                        System.out.print("\rTime: " + formatTime(time));
                    }

                    Thread.sleep(50); // update 20 times per second
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        private void start() {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("\nStopwatch started.");
        }

        private void stop() {
            elapsedTime += System.currentTimeMillis() - startTime;
            running = false;
            System.out.println("\nStopwatch stopped at " + formatTime(elapsedTime));
        }

        private void reset() {
            elapsedTime = 0;
            running = false;
            System.out.println("\nStopwatch reset.");
        }

        private String formatTime(long millis) {
            long hours = millis / 3600000;
            long minutes = (millis % 3600000) / 60000;
            long seconds = (millis % 60000) / 1000;
            long ms = millis % 1000;
            return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, ms);
        }

    }
