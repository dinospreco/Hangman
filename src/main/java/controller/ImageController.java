package controller;

import model.Game;
import services.ImageService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/image")
public class ImageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        ImageService imageService = new ImageService();
        String picturePath = imageService.picturePath(game);

        if (game == null) picturePath = "/png/066.png";

        resp.setContentType("image/png");
        String pathToWeb = getServletContext().getRealPath(File.separator);

        File f = new File(pathToWeb + picturePath);
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = resp.getOutputStream();
        ImageIO.write(bi, "jpg", out);

        out.close();
    }
}
