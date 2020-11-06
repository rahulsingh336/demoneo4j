# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Data Neo4j](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-neo4j)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with Neo4j](https://spring.io/guides/gs/accessing-data-neo4j/)

1.) CREATE(:Person {name: "Ann"}) - [:LOVES]-> CREATE(:Person {name: "Dan"})
//double create didn't work -  CREATE(:Person {name: "Ann"}) - [:LOVES]-> CREATE(:Person {name: "Dan"})
2.) MATCH
     (:Person {name: "Ann"})-[:LOVES]->(op:Person)
    RETURN
      op
3.) MATCH
     (a:Person)-[:DRIVES]->(c:Car)
     WHERE
      a.name='Ann'
     RETURN
       c
       
4.) MATCH
         (p:Person)-[l:LOVES]->(op:Person)
    RETURN
       op,p,l
       
5.) MATCH (p:Person {name: "Ann"}) 
    DETACH DELETE p
    
    
junk:-

CREATE(:Person {name: "Ann"}) - [:LOVES]-> (:Person {name: "Dan"})


MERGE (a:Person {name:"Ann"})
ON CREATE SET
   a.twitter = "@ann"
MERGE (a)-[:LOVES]->(:Person {name:"Pinto"})

MATCH (p:Person {name: "Ann"})-[l:LOVES]->(op:Person)
RETURN p,l,op

MATCH (n)
RETURN n

RETURN gds.version()

CALL gds.list()

##Sample Data
CREATE CONSTRAINT ON (n:Place) ASSERT n.id IS UNIQUE
CREATE(:Place {name: "0", id: 0}) - [:CONNECTS_TO {distance: 4}]-> (:Place {name: "1", id: 1})
CREATE(:Place {name: "2", id: 2})

//MERGE (a:Place {name: "0", id: 0}), (b:Place {name: "2", id: 2})
//MERGE (a)-[:CONNECTS_TO{distance: 8}]->(b)

MATCH (a:Place {name: "0", id: 0}),(b:Place {name: "2", id: 2}) 
CREATE (a)-[r:CONNECTS_TO{distance: 8}]->(b) 
RETURN r

MATCH (a:Place {name: "1", id: 1}),(b:Place {name: "2", id: 2}) 
CREATE (a)-[r:CONNECTS_TO{distance: 2}]->(b) 
RETURN r

MERGE (a:Place {name: "1", id: 1})
MERGE (a)-[:CONNECTS_TO{distance: 5}]->(b:Place {name: "3", id: 3})

MATCH (a:Place {name: "2", id: 2}),(b:Place {name: "3", id: 3}) 
CREATE (a)-[r:CONNECTS_TO{distance: 5}]->(b) 
RETURN r

MERGE (a:Place {name: "3", id: 3})
MERGE (a)-[:CONNECTS_TO{distance: 4}]->(b:Place {name: "4", id: 4})

MATCH (a:Place {name: "2", id: 2}),(b:Place {name: "4", id: 4}) 
CREATE (a)-[r:CONNECTS_TO{distance: 9}]->(b) 
RETURN r

## shorted path
MATCH (source:Place {id: 3}),
(destination:Place {id: 0})
CALL gds.alpha.shortestPath.stream({
startNode: source,
endNode: destination,
nodeProjection: "*",
relationshipProjection: {
all: {
type: "*",
properties: "distance",
orientation: "UNDIRECTED"
}
},
relationshipWeightProperty: "distance"
})
YIELD nodeId, cost
RETURN gds.util.asNode(nodeId).id AS place, cost 

MATCH (a:Place {name: "2", id: 2})
DETACH DELETE a




Deployment
mvn clean deploy
https://www.geekyhacker.com/2019/07/14/how-to-use-spotify-docker-maven-plugin/




