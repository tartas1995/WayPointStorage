# WayPointStorage

This is a Plugin for Spigot. Which allows users to store locations with a name on the server and view them at any time.
This makes it easier to bigger teams to find the project of another team member without having to ask them for the 
coordinates. Or help new joined players to explore the server.

# Usage

## Create WayPoint
One of these:

```
/createWayPoint NAME
/makeWayPoint NAME
/cwp NAME
/mwp NAME
```
## Delete WayPoint
One of these:

```
/deleteWayPoint NAME
/removeWayPoint NAME
/dwp NAME
/rwp NAME
```
## Show WayPoint
One of these:

```
/showWayPoint NAME
/viewWayPoint NAME
/getWayPoint NAME
/shw NAME
/vwp NAME
/gwp NAME
```
## List WayPoints
One of these:

```
/listWayPoints
/lwp
/showWayPoints
```

# Build
This describes how to build this plugin on debian 11.

## Install maven
open a terminal and run
```
apt install maven
```
## compile
open a terminal in the project directory and run
```
mvn package
```
