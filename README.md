# WebCrawler
WebCrawler exercise by Mark Dwyer

Here is an outline Web Crawler. 

The WE Crawler starts at a URL and searches out <A> tags. If the href of the A tags are sub-pages of the original URI it will follow these pages as well and recursively descend until it runs out of links to follow. A well as <a> tags it locates <IMG> tags, looking for PNG, JPG, JPEG and GIF format files.  There is an amount of logging done simply to standard System.out.println. 

The Structure shared here is an Eclipse project containing a JEE Servlet WeApp client.  The webCrawler is included as a JAR file containing source code for review.  The code is a bit run-on and uses the JSOUP document model which offers a fast and easy capability for interrogating HTML pages. The basic servlet can be access by launching the index.html in any  browser.  The WebApp should be deployed to a TOMCAT or VFABRIC server. 

The intention was to provide a gradle build to compile the source, create JAR files and the Application WAR file but I ran into a number of issues prototyping this build which meant that I didn't achieve this, so the JAR and WAR build were menu-based opeerations from within the IDE, Eclipse in this case. 

The webCrawler Class uses a Main method in lieu of JUnits - again this was a choice for brevity. 

The output too is a simple list of links and images found.  The test site I used was a brochure website I wrote for a friends business a good many years ago ( htttp://www.bunrattyhaven.com ) 

A problem with the webcrawler is that for large and deep sites such as http://www.lch.com the http request tends to timeout so that a better approach would be to spawn an asynchronous task to do the crawl rather than attempt to do this within the span of an http request. 

There are many many many things that could be improved in this webcrawler but I think in large I have demonstrated that I can build a client framework, segregate the webcrawler as a service and call it from the client and reflect the recursive nature of the web pages. 

I hope these notes and the little code I have written demonstrate my approach and awareness of how tasks like this might be approached. 

Mark Dwyer - 8th December 2016 
