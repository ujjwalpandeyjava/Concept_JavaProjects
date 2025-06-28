# Profiles

There are several ways to activate a profile in Spring Boot:

## Programmatically 

Set active profiles by calling `SpringApplication.setAdditionalProfiles(...)` before application runs.

It's also possible to activate profiles using Spring’s `ConfigurableEnvironment` interface.

## Using a Property

The `spring.profiles.active` is a standard property that Spring Boot will pick up automatically to activate a profile. Add  profile name to this property value to activate that profile.

If want to activate multiple profiles, can pass comma-separated names of those profiles.

## Using an Environment Variable

You can set an environment variable named `SPRING_PROFILES_ACTIVE` to specify which profiles are active.

## Using a Command Line Argument

When starting application, use a command line argument to specify the active profiles, like so: `--spring.profiles.active=dev,hsqldb`.

---
## Note

1.  Using the `@Profile` Annotation
 	- You can use the `@Profile` annotation on your configuration classes or methods to indicate they should be used only when a certain profile or profiles are active.
 	- The last profile added gets the highest precedence.