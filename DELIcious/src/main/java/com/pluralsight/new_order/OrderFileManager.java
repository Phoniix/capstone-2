package com.pluralsight.new_order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {
    private static final String FILE_PATH = "orders/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy__HH-mm-ss")) + ".csv";

    public static void writeReceipt (Order newOrder) {
        try (BufferedWriter lilJon = new BufferedWriter(new FileWriter(FILE_PATH))) {
            lilJon.write(newOrder.toString());
        } catch (IOException e) {
            System.out.println("Code Broke");
            throw new RuntimeException(e);
        }
    }

}
