package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Room;
import service.RoomService;
import service.RoomServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServlet extends HttpServlet {

    private final RoomService roomService = new RoomServiceImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Room> allRooms = roomService.getAllRooms();
        PrintWriter output = response.getWriter();
        String result = objectMapper.writeValueAsString(allRooms);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        output.print(result);
        output.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Room room = objectMapper.readValue(reqBody, Room.class);
        roomService.save(room);
        PrintWriter output = response.getWriter();
        output.print("The room number " + room.getNumber() + " created");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        String number = request.getParameter("number");
        boolean result = roomService.deleteByNumber(Integer.parseInt(number));
        if (result) {
            output.print("The room with number " + Integer.parseInt(number) + " deleted");
        } else {
            output.print("The room with number " + Integer.parseInt(number) + " doesn't exist");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        String reqBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        int paramId = Integer.parseInt(request.getParameter("number"));
        Room room = objectMapper.readValue(reqBody, Room.class);
        room.setAccess(room.isAccess());
        room.setNumber(paramId);
        roomService.update(room, room.isAccess());
        output.print(room);
    }
}
