#TAWServerUpdater

##How to use

The program needs 3 arguments to run properly. The first argument defines the sourcefolder, the second one the destination of the outdated files and third one is the method you want to use.

In the following I will explain how you need to execute the program depending on what method you are using.

###Update Server

If you want to update your server (the craftbukkit.jar), make sure that your are doing the following:

* The first argument is the complete path to the sourcefolder (in which the craftbukkit.jar is located)
* The second argument is the complete path to the destination folder, in which you find all serverdirectories
* The third argument has to be "server"

Your command should then look like this:
>java -jar TawServerUpdater.jar E:\Server\serversource E:\Server\bungee server

This will update all servers in the directory bungee.

###Update Plugin

To update a specific plugin, this is your way to go:

* The first argument: complete path to the jar of the plugin
* The second argument: complete path to the destination folder
* The third argument: "plugin"

Example:
>java -jar TawServerUpdater.jar E:\Server\serversource\plugins\plugin.jar E:\Server\bungee plugin

###Update all Plugins

This actually works like something between the previous ones:

* The first argument: complete path to the plugins folder of the sourcefolder
* The second argument: complete path to the destination folder
* The third argument: "allplugins"

Example:
>java -jar TawServerUpdater.jar E:\Server\serversource\plugins E:\Server\bungee allplugins
