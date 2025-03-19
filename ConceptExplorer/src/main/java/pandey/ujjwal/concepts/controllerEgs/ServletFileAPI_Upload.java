package pandey.ujjwal.concepts.controllerEgs;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import pandey.ujjwal.concepts.utility.fileUtil.FileUtility;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ServletFileAPI_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletFileAPI_Upload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Part inputFilePart = request.getPart("fileToUpload");

			Boolean isFileAvailableSoSave = inputFilePart.getSize() > 0;
			String directoryPath = FileUtility.createSaveFileAndDirectory("toDoWithImage", id, inputFilePart, isFileAvailableSoSave, false);
			System.out.println(directoryPath);
			
			HttpSession session = request.getSession();
			session.setAttribute("add-success", "Added successfully!");
			response.sendRedirect("showAllToDo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}