# WebCrawler
WebCrawler exercise by Mark Dwyer

Here is an outline Web Crawler. 

The WE Crawler starts at a URL and searches out <A> tags. If the href of the A tags are sub-pages of the original URI it will follow these pages as well and recursively descend until it runs out of links to follow. A well as <a> tags it locates <IMG> tags, looking for PNG, JPG, JPEG and GIF format files.  There is an amount of logging done simply to standard System.out.println. 
The Structure shared here is an Eclipse project containing a WEbApp client.  Teh webCrawler is included as a JAR file containing sources code for review.  The basic servlet can be access by launching the index html in a browser.  The WEbApp should be deployed to a TOMCAT or VFABRIC server. 

The intention was to provide a gradle build to dompile the source, create JAR files and the Application WAR file. 
The webCrawler Class uses a Main method in lieu of JUnits - though this was a choice for brevity. 

The output too is a simple list of links and images found.  The test site I used was a brochure website I wrote for a friends business a good many years ago ( htttp://www.bunrattyhaven.com ) 

A problem with the webcrawler is that for large and deep sites such as http://www.lch.com the http request tends to timeout so that a better approach would be to spawn an asynchronous task to do the crawl rather than attempt to do this within an http request. 

There are many many things that could be improved in this webcrawler but I think in large I have demonstrated that I can build a client framework, segregate the webcrawler as a service and call it from the client and reflect the recursive nature of the web pages. 

I hope these notes and the little code I have written demonstrate my approach and awareness of how tasks like this might be approached. 
