package com.example.myapplication;

import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private static File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS); // /storage/emulated/0/Documents

    public static void createFileAPI30(){
        try {
            File file = new File(dir, "example.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // this method worked only on API 30
    public static void writeToFileAPI30(){
        File file = new File(dir, "example.txt");
        if(file.exists()){
            //Write to file
            try (FileWriter fileWriter = new FileWriter(file)) {
                System.out.println("writing to file");
                fileWriter.append("Writing to file!");
            } catch (IOException e) {
                System.out.println("writeFile exception");
                //Handle exception
            }
        }
    }


    // deprecated way of creating a document
    private void CreateAndWriteFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);

        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "intentFile.txt");

        //startActivityForResult(intent, 1); // deprecated
    }

}
