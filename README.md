# Natural-Harvest [![Build Status](https://travis-ci.org/NotAModder/Natural-Harvest.svg?branch=master)](https://travis-ci.org/NotAModder/Natural-Harvest) [![](http://cf.way2muchnoise.eu/266333.svg)](https://minecraft.curseforge.com/projects/natural-harvest) [![](http://cf.way2muchnoise.eu/versions/266333.svg)](https://minecraft.curseforge.com/projects/natural-harvest)
Natural Harvest is a content mod for Minecraft that is inspired by games like Harvest Moon, and Stardew Valley. The mod is currently in it's early stages, which means there will be new content on a nearly daily basis!

## Building
This project is currently using CurseForge's Maven. This may change in the future. To add this project as a dependency using gradle, add the following repository to the repository list. Alternatively, you can use [JitPack](https://jitpack.io/) which is a bit more thought out that Curse's maven system.

```
repositories {
    maven {
        name = "CurseForge"
        url = "https://minecraft.curseforge.com/api/maven/"
    }
}
```

Once you have the repo added to your list, you can pull the library by adding the following to your dependencies. 

```
compile "notural-harvest:NaturalHarvest:1.11.2:1.0.+"
```

To explain Curse's maven system, the first bit is the slug for the project (The name in the url), and then add the name of the file you want but replace all dashes with colons. That's the gist of it at least. 