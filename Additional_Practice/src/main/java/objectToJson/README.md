# 3 different library to work with Object and JSON in java
	From simple to complex

## GSON
1. POJO <--> JSON String, in multiple ways
2. Cannot create without POJO

	https://howtodoinjava.com/gson/gson/
	<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
	<dependency>
		<groupId>com.google.code.gson</groupId>
		<artifactId>gson</artifactId>
		<version>2.10.1</version>
	</dependency>

## org.json
Use: 
1. POJO <--> JSON String, in simple way
2. Can create with without POJO
	
	<!-- https://mvnrepository.com/artifact/org.json/json -->
	<dependency>
	    <groupId>org.json</groupId>
	    <artifactId>json</artifactId>
	    <version>20231013</version>
	</dependency>


## Jackson
use: 
1. POJO <--> JSON String, in multiple way
2. Can create with without POJO
3. Have multiple type of jsonOjects

	https://www.baeldung.com/jackson-object-mapper-tutorial
	<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-core</artifactId>
		<version>2.16.0</version>
	</dependency>
	
	
	
	
	
---
```
Here's a table comparing Jackson, org.json, and GSON in terms of differences and similarities:
|-------------------------------------------|---------------------------------------------------|----------------------------------------------------|--------------------------------------------------|
| Feature                                   | Jackson                                           | org.json                                           | GSON                                            |
|-------------------------------------------|---------------------------------------------------|----------------------------------------------------|--------------------------------------------------|
|   Library Type                            | Streaming and Tree Model                          | Tree Model                                         | Streaming and Tree Model                          |
|   Supports Annotations                    | Yes                                               | No                                                 | Yes                                              |
|   Streaming API                           | Yes                                               | No                                                 | Yes                                              |
|   Tree Model API                          | Yes                                               | Yes                                                | Yes                                              |
|   Performance                             | High                                              | Moderate                                           | High                                             |
|   Ease of Use                             | Moderate to High                                  | Moderate                                           | High                                             |
|   Customization Options                   | Extensive                                         | Limited                                            | Moderate                                         |
|   Support for Polymorphism                | Yes                                               | No                                                 | Yes                                              |
|   Integration with Spring Framework       | Yes                                               | No                                                 | Yes                                              |
|   Supported Data Formats                  | JSON, Smile, CBOR, XML, YAML, Properties, and more | JSON                                               | JSON                                             |
|   Null Handling                           | Configurable                                      | Limited                                            | Configurable                                      |
|   License                                 | Apache License 2.0                                | MIT License                                        | Apache License 2.0                               |
|   Open Source                             | Yes                                               | Yes                                                | Yes                                              |
|   Community Support                       | Strong                                            | Moderate                                           | Strong                                           |

Please note that the assessment of ease of use and performance can be subjective and may vary based on specific use cases and individual preferences. It's recommended to evaluate these libraries based on your project requirements and preferences.```