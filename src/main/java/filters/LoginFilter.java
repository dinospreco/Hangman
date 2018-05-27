package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class LoginFilter implements Filter {

    //Source:
    //https://stackoverflow.com/questions/31318397/webfilter-exclude-url-pattern?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/logout", "/profile", "/game", "/newGame")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        if (ALLOWED_PATHS.contains(path)) {

            session = req.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                req.getRequestDispatcher("view/home.jsp").forward(req,resp);
            }
            else {
                filterChain.doFilter(req,resp);
            }

        }
        else {
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
