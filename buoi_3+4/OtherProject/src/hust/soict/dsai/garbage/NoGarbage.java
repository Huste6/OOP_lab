package hust.soict.dsai.garbage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
		String filename = "C:\\Users\\Admin\\eclipse-workspace\\OOP_lab\\buoi_3\\OtherProject\\src\\hust\\soict\\dsai\\garbage\\test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        // Check if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("Error: File not found: " + filename);
            return;
        }

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuilder = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuilder.append(Character.toString((char) b));
        }
        endTime = System.currentTimeMillis();
        System.out.println(outputStringBuilder);
        System.out.println(endTime - startTime);
	}
}
