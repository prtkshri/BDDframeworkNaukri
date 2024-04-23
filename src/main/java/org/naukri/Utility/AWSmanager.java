package org.naukri.Utility;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AWSmanager extends Base {
    private String AWS_ACCESS_KEY = getProperty("accesskey");
    private String AWS_SECRET_KEY = getProperty("secretkey");
    private String BUCKET_NAME = getProperty("bucketname");
    private String PDF_KEY = getProperty("pdfkey");

    public AWSmanager() throws Exception {
    }

    public void getFile() {
        // Create credentials object with your AWS access key and secret key
        BasicAWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
        Regions region = Regions.AP_NORTHEAST_1; // Replace YOUR_REGION with the appropriate AWS region

        // Create an S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();

        // Retrieve the PDF file from the S3 bucket
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(BUCKET_NAME, PDF_KEY));

        // Read the content of the object
        try {
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            FileOutputStream outputStream = null;
            String dir = System.getProperty("user.dir");
            outputStream = new FileOutputStream(new File(dir + "/src/test/resources/downloaded_file.pdf"));


            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("PDF file downloaded successfully.");

        } catch (
                Exception ex) {
            ex.printStackTrace();
        }

    }
}
