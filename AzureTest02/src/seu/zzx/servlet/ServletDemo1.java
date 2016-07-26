package seu.zzx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import seu.zzx.api.VisitAPI;
import seu.zzx.list.AttributeList;
import seu.zzx.path.HopPathsForAuIdToAuId;
import seu.zzx.path.HopPathsForAuIdToId;
import seu.zzx.path.HopPathsForIdToAuId;
import seu.zzx.path.HopPathsForIdToId;

/**
 * Servlet implementation class ServletDemo1
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		long start = System.currentTimeMillis();
		//long id1 = Long.parseLong(request.getParameter("id1"));
		//long id2 = Long.parseLong(request.getParameter("id2"));
		//System.out.println(id1 + "," + id2);
		//JSONArray path = getPath(id1,id2);
		//System.out.println(path);
		out.println("zhouzhixing");
		out.flush();
		out.close();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public JSONArray getPath(long id1,long id2) {
		JSONArray path = new JSONArray("[]");
		boolean flagID1 = false;
		boolean flagID2 = false;
		flagID1 = VisitAPI.isPaperId(id1);
		flagID2 = VisitAPI.isPaperId(id2);
		if (flagID1 && flagID2) {
			path = HopPathsForIdToId.getPath(id1, id2);
		}else if(!flagID1&&!flagID2){
			path = HopPathsForAuIdToAuId.getPath(id1, id2);
		}else if(flagID1&&!flagID2){
			path = HopPathsForIdToAuId.getPath(id1, id2);
		}else if(!flagID1&&flagID2){
			path = HopPathsForAuIdToId.getPath(id1, id2);
		}
		return path;
	}
}
