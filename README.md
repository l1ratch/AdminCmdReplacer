Плагин ACR предназначен для блокировки и изменения сообщения базовых команд ядра(Имеет список для блокировки произвольных команд)

Единственная команда плагина /AdminCmdReplacer reload или /ACR reload - перезагружает конфиг плагина! (Не рекомендуется использовать)

Конфигурация:
```
# Блокировка TabComplete(Авто-Таб)
TabComplete:
  Allow: false

# Когда игрок прописывает одну из разновидностей команды /Help - он получает текст из пункта msg: ""
Help:
  Allow: true
  msg:
    - "&fPlugins unloaded..."
  cmd:
    - "help"
    - "Help"
    - "?"
    - "bukkit:help"
    - "bukkit:Help"
    - "bukkit:?"
    - "Bukkit:help"
    - "Bukkit:Help"
    - "Bukkit:?"

# Когда игрок прописывает одну из разновидностей команды /About - он получает текст из пункта msg: ""
About:
  Allow: true
  msg:
    - "&fThis server is running LinkCore version SuperVersion (MC: Super) (Implementing API version Super-R0.1)"
  cmd:
    - "about"
    - "About"
    - "bukkit:about"
    - "bukkit:About"
    - "Bukkit:about"
    - "Bukkit:About"

# Когда игрок прописывает одну из разновидностей команды /Version - он получает текст из пункта msg: ""
Version:
  Allow: true
  msg:
    - "&fThis server is running LinkCore version SuperVersion (MC: Super) (Implementing API version Super-R0.1)"
  cmd:
    - "version"
    - "Version"
    - "ver"
    - "Ver"
    - "bukkit:version"
    - "bukkit:Version"
    - "bukkit:ver"
    - "bukkit:Ver"
    - "Bukkit:version"
    - "Bukkit:Version"
    - "Bukkit:ver"
    - "Bukkit:Ver"

# Когда игрок прописывает одну из разновидностей команды /Plugins - он получает текст из пункта msg: ""
Plugins:
  Allow: true
  msg:
    - "&fPlugins (2): &aLinksCore&f, &aLinksPerm"
  cmd:
    - "plugins"
    - "Plugins"
    - "pl"
    - "Pl"
    - "bukkit:plugins"
    - "bukkit:Plugins"
    - "bukkit:pl"
    - "bukkit:Pl"
    - "Bukkit:plugins"
    - "Bukkit:Plugins"
    - "Bukkit:pl"
    - "Bukkit:Pl"

# Когда игрок прописывает одну из разновидностей команды /op или /deop - он получает текст из пункта msg: ""
Op:
  Allow: true
  msg:
    - "§6§lSecurity §f| Император запретил тебе делать это!"
  cmd:
    - "op"
    - "deop"
    - "minecraft:op"
    - "minecraft:deop"

# Когда игрок прописывает одну из команд списка cmd: "" - он получает текст из пункта msg: ""
BlockCMD:
  Allow: true
  msg:
    - "§6§lServer §f| §cУпс.. Похоже такой команды не существует!"
  cmd:
    - icanhasbukkit
    - plugman
    - protect
    - pex
    - tpaall
    - chestcommands
    - etpaall
    - minecraft
   ```
