package controller;

import model.Word;
import services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addWord")
public class AddWordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/add_Word.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminService adminService = new AdminService();

        String word = req.getParameter("word");
        String category = req.getParameter("category");

        if (adminService.validWord(word)) {
            Word wordObj = new Word();
            wordObj.setWord(word);
            wordObj.setCategory(category);
            if (adminService.addWord(wordObj)) {
                req.getRequestDispatcher("/view/addWordSuccess.jsp").forward(req,resp);
            }
            else {
                req.getRequestDispatcher("/view/addWordFailure.jsp").forward(req,resp);
            }
        }
    }
}
