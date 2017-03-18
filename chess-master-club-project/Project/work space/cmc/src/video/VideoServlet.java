package video;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoServlet
 */
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		p(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		p(request, response);
	}
	
	protected void p(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String video=request.getParameter("video");
		   response.setContentType("text/html");
		   PrintWriter out=response.getWriter();
		   out.println("<script src='videos/AC_RunActiveContent.js' language='javascript'></script><!-- saved from url=(0013)about:internet --><script language='javascript'> AC_FL_RunContent('codebase', 'http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0', 'width', '600', 'height', '400', 'src', ((!DetectFlashVer(9, 0, 0) && DetectFlashVer(8, 0, 0)) ? 'OSplayer' : 'OSplayer'), 'pluginspage', 'http://www.macromedia.com/go/getflashplayer', 'id', 'flvPlayer', 'allowFullScreen', 'true', 'allowScriptAccess', 'always', 'movie', ((!DetectFlashVer(9, 0, 0) && DetectFlashVer(8, 0, 0)) ? 'OSplayer' : 'OSplayer'), 'FlashVars', 'movie=videos/"+video+".flv');</script><noscript> <object width='400' height='325' id='flvPlayer'> <param name='allowFullScreen' value='true'> <param name='allowScriptAccess' value='always'><param name='movie' value='videos/OSplayer.swf?movie=videos/"+video+".flv'><embed src='videos/OSplayer.swf?movie=videos/"+video+".flv' width='400' height='325' allowFullScreen='true' type='application/x-shockwave-flash' allowScriptAccess='always'></object></noscript>");
	}

}
