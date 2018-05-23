package controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/image")
public class ImageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("image/jpeg");
        String pathToWeb = getServletContext().getRealPath(File.separator);
        File f = new File(pathToWeb + "/png/Gallow1.png");
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = resp.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.close();
    }
}
