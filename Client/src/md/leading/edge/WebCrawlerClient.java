/**
 * 
 */
package md.leading.edge;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.leading.edge.webcrawler.WebCrawler;

/**
 * @author mark.dwyer
 * @param <E>
 *
 */
public class WebCrawlerClient<E> extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WebCrawler myWebCrawler = new WebCrawler(); 
	

	
	public void doGet ( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		  // Set response content type
		  res.setContentType("text/html");
		  
		  HashMap<String, String> siteMap = null ; 
		  siteMap = new HashMap<String,String>(); 
		  
		  String output = "No Output **" ; 
		  try {
			  
			siteMap = myWebCrawler.crawl(siteMap, new URI(req.getParameter("crawlURI")));
			Iterator<String> outputIterator = siteMap.keySet().iterator() ; 
			StringBuffer sbuf = new StringBuffer(); 
			sbuf.delete(0, sbuf.length());
			System.out.println("size of output *** "+ siteMap.size());
			
			while (outputIterator.hasNext()) { 
				sbuf.append("<p>");
				sbuf.append(siteMap.get(outputIterator.next())); 
				sbuf.append("</p>"); 
			}
			
			sbuf.append("<hr>");
			if (sbuf.length() > 0 ) { 
				output = sbuf.toString() ; 
			}
		} catch (Exception e) {
			output = "Invalid URI!";
		}
		
		  PrintWriter out = res.getWriter();
		  String title = "Web Crawler Output";
		  String docType =
		  "<!doctype html public \"-//w3c//dtd html 4.0 " +
		  "transitional//en\">\n";
		  out.println(docType +
		            "<html>\n" +
		            "<head><title>" + title + "</title><style>"+
					"body {font-family: verdana;}"+
					"h1 { background-color:#CCC;    border: 1px solid;    color:#39F;    text-align: center;    }"+
					"table { background-color: #F60;    border: 1px solid #39F;    width: 100%;    }"+
					"td {order: 0px;    text-align: center;    }"+
					"p {color:#09F;    text-indent: 20px;        }"+
					".md {color:red; flashing; text-decoration: underline;; font-size:10px}"+
					"</style></head>\n" +
		            "<body bgcolor=\"#f0f0f0\">\n" +
		            "<h1 align=\"center\">" + title + "</h1>\n" +
		            "<ul>\n" +
		            "  <li><b>Crawl URI Supplied</b>: "
		            + req.getParameter("crawlURI") + "\n" +
		            "</ul>\n" +
		            "<hr>" + 
		            "<div align=\"center\">" + output + "</div>" +  
		            "</body></html>");
				
	}

}
