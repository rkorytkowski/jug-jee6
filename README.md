# feedmanager

## Application background

Feedmanager is a simple JEE6 application showcase, to outline new features in JEE6 and their testability. 

The application is a pubsubhubbub subscriber, which consumes RSS feeds, parses it into a simplified model, stores data and allows servlet and SOAP based reports. 

I know this does not sound like a solid base of requirements for an application but it's enough to walk through multiple features of JEE6 and show how it shifts design paradigms and boosts app testability. 

### The pubsubhubbub 

This is 
> a simple, open, server-to-server web-hook-based pubsub (publish/subscribe) protocol as an extension to Atom and RSS.
> 
> Parties (servers) speaking the PubSubHubbub protocol can get near-instant notifications (via webhook callbacks) when a topic (feed URL) they're interested in is updated. 

## Project organisation 

Application is a monolythic application, deployed as a single WAR. The working environment is a [TomEE application server][1]

Each commit addresses a single requirement, together with multiple levels of testing: unit and integration. 

## Requirements

1. Walking skeleton

    Initial commit, which includes pom.xml - which is sufficient to deploy onto application server. A simple `mvn package` command wraps everything into a WAR file which is fully deployable onto the application server.
    No additional dependencies are required, because the full stack is provided by the application server.  

2. Parsing RSS feed

	An incoming RSS item must be parsed and basic feed information must be extracted into an application model.
	Rome library is used for parsing, which is later mapped onto custom model.  
	
[1]: http://tomee.apache.org/	"TomEE all-Apache Java EE 6 Web Profile"