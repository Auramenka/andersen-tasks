package servlets;

import model.ReservationDate;
import service.ReservationDateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ReservationDateServlet extends HttpServlet {

    private final ReservationDateService reservationDateService = new ReservationDateService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setDateStart(LocalDate.parse(dateStart));
        reservationDate.setDateEnd(LocalDate.parse(dateEnd));
        boolean result = reservationDateService.availableReservationDate(reservationDate);
        if (result) {
            output.print("You can book for this date");
        } else {
            output.print("You can't book for this date");
        }
    }
}
