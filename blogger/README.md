# Description and Detail

1. Multi-Module Project:
    - A multi-module project is a way to divide an application into multiple modules, each with a specific function and
      dependency.
2. Aggregator POM:
    - The pom of parent module, the dependencies present in it are shared by all the submodules.
3. Advantages
    - It provides a great ability to build all submodules only with a single command,
    - The code from the various modules across different projects can be re-used, *(saving time wasted in calling
      APIs/services)*
    - We can run the build command from the parent module,
    - While building the application, the build system takes care of the build order,
    - Deployment of the applications gets very convenient and flexible,
    - Multi-Module Project architecture, also grants benefits from the microservices architecture.

---

# Steps
## Creating a multi module project

1. Crate a maven/spring-boot project with packaging type pom only,
2. Add submodule: File > New > Module (choose parent: ParentProject_multiModule)
3. Add these  
   ```
   In parent:
   <modules>
      <module>Sub-Module-Name<module>
   </modules>

   In sub modules:
   <parent>
        <groupId>pandey.ujjwal</groupId>
        <artifactId>blogger</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
   ``` 

## When to use multi-module?
**A multi-module project is beneficial when you have an application that consists of several modules, each playing a significant role in the application’s functionality.**

- **Reduce Duplication:** Application that consists of several modules, and working and changing the functionality which affects them both, a multi-module project can help reduce duplication.
- **Manage Complexity:** As your project grows and gets more modules, it becomes harder to manage and maintain. A multi-module project can help manage this complexity.
- **Efficient Build Process:** With a multi-module project, you can build your application’s modules in a single command. If the order matters, Maven will figure it out for you.
- **Shared Configuration:** You can share a vast amount of configuration with other modules.
- **Reusability:** The code from the various modules across different projects can be reused.
- **Microservices Architecture:** With the help of Multi-Module Project architecture, we can gain benefits from the microservices architecture.
- **Remember:** a multi-module project is just a set of multiple projects where each project has its own respective function. It’s important to note that all the dependencies you have enlisted in the pom.xml of the parent module will be automatically inherited by submodules directly.


## How can we deploy it on server?

1. Spring boot application:
   Might need to deploy each application separately 
   ```
   If your Spring Boot project is a multi-module project with POM packaging and has sub-modules, you can still deploy it on Tomcat. Here are the steps:

   1. **Build the Project**: Run `mvn clean install` at the parent project level. This will build all the sub-modules¹.

   2. **Identify the WAR Module**: One of your sub-modules should be a WAR module that depends on the other JAR modules¹. This is the module you'll be deploying.

   3. **Copy the WAR to Tomcat**: After building the project, find the generated WAR file in the `target` directory of your WAR sub-module. Copy this file to the `webapps` directory of your Tomcat installation¹.

   4. **Start Tomcat**: Start your Tomcat server. You can do this by navigating to the `bin` directory of your Tomcat installation and executing the `startup.sh` (for Unix-based systems) or `startup.bat` (for Windows) script¹.

   Remember, the exact process can vary based on the specifics of your project and the server you're deploying to. Always refer to the documentation of the tools and platforms you're using for the most accurate information. If you encounter any issues, feel free to ask! 😊
   ```

2. Simple Maven application:
   - ABC
---