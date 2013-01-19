package pl.marchwicki.feedmanager.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.marchwicki.feedmanager.model.Feed;
import pl.marchwicki.feedmanager.model.FeedBuilder;

@WebServlet(urlPatterns="/web/consume/*")
public class ConsumerServlet extends HttpServlet {

	private static final long serialVersionUID = -3793876752332268424L;

	@Inject
	FeedBuilder builder;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String rssbody = req.getParameter("rss");
		Feed feed = builder.fromXml(rssbody);

		PrintWriter writer = resp.getWriter();
		writer.append("There are " + feed.getItems().size()
				+ " articles in the feed");
		writer.flush();
		
	}

	
	
}