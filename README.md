# GrechConfigPlugin

Minecraft spigot plugin that handles configuration loading for other plugins.

## Maven dependency

```xml
<repository>
    <id>nurio-repo</id>
    <url>https://maven.nurio.me/</url>
</repository>
```

```xml
<dependency>
    <groupId>me.nurio</groupId>
    <artifactId>bukkit.configuration</artifactId>
    <version>1.2</version>
    <scope>provided</scope>
</dependency>
```

## Usage examples

```java
// Instanciate the GrechConfig class
// GrechAreas is the main class of the GrechAreas plugin
GrechConfig config = new GrechConfig(GrechAreas.getPlugin(), "areas" + File.separator + file.getName());

// Retrieve data from the file
String name = config.getConfig().getString("name");
UUID uuid = UUID.fromString(config.getConfig().getString("uuid"));

// Retrieve locations from the file
Location start = config.getLocation("areas.1.start");
Location end = config.getLocation("areas.1.end");
```
