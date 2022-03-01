
# Discord-Meme-Bot

Discord-meme-bot to szybki bot służący do wysyłania randomowych memów na kanałach discorda.

## Wrzucanie memów z różnych żródeł
- Mysql (link  w bazie danych do mema)
- Wrzucony plik w folder "memiki"
##

## Demo

![](https://i.gyazo.com/62bd0bbd1cba2f17df8961bf58dc8eda.gif)

## Pełna konfiguracja bota
confing.yml
```
token: "" #Discord Bot token https://discord.com/developers/applications
activity: "©Gaway-code" #Widoczna aktyność bota
mysql: "false" #Pobieranie danych z mysql z tabeli memki kolumna link (jeżeli wyłaczone to pobiera dane z folderu memiki)
admintag: "Gaway#4391" #Nick uprawniony do aktualizacji memów (z plików lub bazy)
database: #dane do mysql
  ip: ""
  port: ""
  database: ""
  user: ""
  pass: ""
memetitle: "Codzienna dawka memów" #Tytuł przy wysyłaniu mema
updatemessage: "Zaktualizowane liste memów" #wiadomość jaka wyswietla się po wykonaniu komendy aktualizującej memy
permissionmessage: "Nie masz uprawnień" #Wiadomosc wysyłana do osoby bez uprawnień do aktualizacji
memecommand: "!meme" #komenda do wysłania mema
updatecommand: "!update" #komenda do aktualizacji mema

```
## Biblioteki
- yamlconfig
- JDA
- mysql-connector-java

### License
MIT
## Autor

- [@Gaway-code](https://github.com/Gaway-Code)

