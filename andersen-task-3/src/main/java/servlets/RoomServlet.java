package servlets;

import model.Room;
import service.RoomService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RoomServlet extends HttpServlet {

    private final RoomService roomService = new RoomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        output.print(roomService.getAllRooms());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        String number = request.getParameter("number");
        Room room = roomService.createRoom(Integer.parseInt(number));
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
        String number = request.getParameter("number");
        String access = request.getParameter("access");
        roomService.updateRoom(Integer.parseInt(number), Boolean.parseBoolean(access));
        output.print(roomService.getAllRooms());
    }
}
