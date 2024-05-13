package hibernate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.service.HibernateRoomService;
import hibernate.service.HibernateRoomServiceImpl;
import model.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateRoomServlet extends HttpServlet {

    private final HibernateRoomService roomService = new HibernateRoomServiceImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> rooms = roomService.getAllRooms();
        PrintWriter output = resp.getWriter();
        String result = objectMapper.writeValueAsString(rooms);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        output.print(result);
        output.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Room room = objectMapper.readValue(reqBody, Room.class);
        roomService.save(room);
        PrintWriter output = resp.getWriter();
        output.print("The room number " + room.getNumber() + " created");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Room room = objectMapper.readValue(reqBody, Room.class);
        Room updateRoom = roomService.update(room);
        output.print(updateRoom);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter output = resp.getWriter();
        String number = req.getParameter("number");
        roomService.deleteByNumber(Integer.parseInt(number));
        output.print("The room with number " + Integer.parseInt(number) + " deleted");
    }
}
