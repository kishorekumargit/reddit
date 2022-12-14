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
public class EditLike extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLike() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=SessionManager.validateSession(request,response);
        if(username!=null) {
            String likeid = request.getParameter("likeid");
            String postid = request.getParameter("postid");
            String commentid = request.getParameter("commentid");
            System.out.println(commentid);
            boolean status = Boolean.parseBoolean(request.getParameter("status"));

            try {
                System.out.println("Edit Like Here");
//			JsonObject commentData=Database.postComments(username,comment,postid);
                StorageMethods.editLikes(likeid, status, postid,commentid, request, response);
            } catch (Exception e) {
                StorageMethods.throwUnknownError(request, response);
            }
        }else {
            StorageMethods.throwSessionExpired(request,response);
        }


    }

}
