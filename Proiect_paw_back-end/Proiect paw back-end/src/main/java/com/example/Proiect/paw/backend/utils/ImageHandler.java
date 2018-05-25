//package com.example.Proiect.paw.backend.utils;
//
//import org.hibernate.engine.jdbc.StreamUtils;
//
//import java.io.*;
//import java.sql.Blob;
//
//public  class ImageHandler {
//
//    public static byte[] writtingImage(String fileLocation) {
//        File f = new File("//C:/tmp/6mb_file.wmv");
//        BufferedInputStream fstream = new BufferedInputStream(new FileInputStream(f));
//
//        Blob blob = connection.getConnection().createBlob();
//        BufferedOutputStream bstream = new  BufferedOutputStream(blob.setBinaryStream(1));
//        // stream copy runs a high-speed upload across the network
//        StreamUtils.copy(fstream, bstream);
//
//        FileBLOBEntity file = new FileBLOBEntity();
//
//        file.setName("//C:/tmp/6mb_file.wmv");
//        file.setTheData(blob);
//        // save runs a low-speed download across the network.  this is where
//        // Spring does the SQL insert.  For a large file, I get an OutOfMemory exception here.
//        blobRepository.saveAndFlush(file);
//    }
//}
