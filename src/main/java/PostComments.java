import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reddit.StorageMethods;

import java.io.IOException;

/**
 * Servlet implementation class PostComments
 */
public class PostComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostComments() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username").toLowerCase();
        String comment = request.getParameter("comment");
        String postid = request.getParameter("postid");

		try {
//			JsonObject commentData=Database.postComments(username,comment,postid);
			StorageMethods.postComments(username,comment,postid,"Post",null,request,response);
		}catch(Exception e) {
			StorageMethods.throwUnknownError(request,response);
		}

		
	}

}
