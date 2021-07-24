package ru.a1.http_flight.servlet;

import ru.a1.http_flight.dto.CreateUserDto;
import ru.a1.http_flight.entity.Gender;
import ru.a1.http_flight.entity.Role;
import ru.a1.http_flight.exception.ValidationException;
import ru.a1.http_flight.service.UserService;
import ru.a1.http_flight.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/registration")
    public class RegistrationServlet extends HttpServlet {

        private final UserService userService = UserService.getInstance();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("roles", Role.values());
            req.setAttribute("genders", Gender.values());

            req.getRequestDispatcher(JspHelper.getPath("registration"))
                    .forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            var userDto = CreateUserDto.builder()
                    .name(req.getParameter("name"))
                    .birthday(req.getParameter("birthday"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .role(req.getParameter("role"))
                    .gender(req.getParameter("gender"))
                    .build();

            try {
                userService.create(userDto);
                resp.sendRedirect("/login");
            } catch (ValidationException exception) {
                req.setAttribute("errors", exception.getErrors());
                doGet(req, resp);
            }
        }
    }


