# IP-Grabber
[![RunsOn](https://img.shields.io/badge/Used%20technologies-Spring%20%7C%20Kotlin%20-green)]() [![license](https://img.shields.io/github/license/MartinWie/IP-Grabber)](https://github.com/MartinWie/IP-Grabber/blob/main/LICENSE) [![Open Source](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://opensource.org/)

![IP-Grabber](https://github.com/MartinWie/IP-Grabber/blob/main/IP-Grabber-Logo.png)

Small project to social engineer an ip from an enemy entity.
This project is a result of trying to get the ip of a person who blackmailed a close friend.

## Features

### Display your own IP

Just open: 

```
your.domain.com/ip 
```

### Log IP and access of caller:

```
your.domain.com/photo/{id}
```

This saves the IP and other identifiers off the caller in a file next to the JAR file.
For example:

```
your.domain.com/photo/123456
```

produces this output on access by a browser:

```
Path ID: 123456
Remote host: 0:0:0:0:0:0:0:1
Remote address: 0:0:0:0:0:0:0:1
Remote port: 58866
Remote user-agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36
Date formatted: Sat Sep 18 01:31:04 CEST 2021
Date raw: 1631921464932
###
```

The browser will only display an "HTTP ERROR 404" to confuse the attacker.

In combination with the /photo/... endpoint name, you can probably make up a story to social engineer him/her to click a link.

## Quick usage 

Download the latest release.

Run it on any server with 

```
java -jar getIP-0.0.1-SNAPSHOT.jar 
```

The default port is 8080
To customize this port, you can add "--server.port=80"

```
sudo java -jar getIP-0.0.1-SNAPSHOT.jar --server.port=80
```

## TODOS's
- tbd

## Support me :heart: :star: :money_with_wings:
If this project provided value, and you want to give something back, you can give the repo a star or support by making buying me a coffee.

<a href="https://buymeacoffee.com/MartinWie" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" alt="Buy Me A Coffee" width="170"></a>
