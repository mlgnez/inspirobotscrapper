package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        int times = 10;

        String finalName = ""; //dont set this to anything

        for(int i = 0; i < times; i++) {

            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            Random rand = new Random();

            finalName = "";

            for(int e = 0; e < 10; e++){

                int randomLetter = rand.nextInt(AlphaNumericString.length());

                finalName = finalName + AlphaNumericString.toCharArray()[randomLetter];

            }

            System.out.println(finalName);

            //------------------------------

            URL url = new URL("https://inspirobot.me/api?generate=true");

            InputStream is = url.openStream();

            Scanner sc = new Scanner(is);

            StringBuffer sb = new StringBuffer();

            while(sc.hasNext()) {
                sb.append(sc.next());
            }

            String result = sb.toString();

            System.out.println(result);

            //-----------------------------

            BufferedImage image = ImageIO.read(new URL(result));

            File file = new File("");
            ImageIO.write(image, "jpg" ,file);

        }

    }
}
