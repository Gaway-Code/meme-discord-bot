
# Discord-Meme-Bot

Discord-meme-bot to szybki bot służący do wysyłania randomowych memów na kanałach discorda.

## Wrzucanie memów z różnych żródeł
- Json (Jeżeli korzystasz ze strony internetowej [Discord-meme-bot-Panel](https://github.com/Gaway-Code/Discord-meme-bot-Panel))
- Wrzucony plik w folder "memiki"
## komendy
- !meme - wysłanie mema na kanał
- !update - aktualizacja bazy memów
- !reload - przeładowanie configu
- !usun <ilosc> - usuwanie ostatnich wiadmomości na danym kanale

## Demo

![](https://i.gyazo.com/62bd0bbd1cba2f17df8961bf58dc8eda.gif)

## Pełna konfiguracja bota
confing.yml
```
token: "" #Discord Bot token https://discord.com/developers/applications
activity: "©Gaway-code" #Widoczna aktyność bota
json: "false" #Pobieranie danych z mysql z tabeli memki kolumna link (jeżeli wyłaczone to pobiera dane z folderu memiki)
json-url: "http://meme.gaway.pl/json.php" #Url do jsona wygenerowanego z aplikacji (Discord-meme-bot-Panel)
admintag: "Gaway#4391" #Nick uprawniony do aktualizacji memów (z plików) i do usuwania wiadomości
memetitle: "Codzienna dawka memów" #Tytuł przy wysyłaniu mema
updatemessage: "Zaktualizowane liste memów" #wiadomość jaka wyswietla się po wykonaniu komendy aktualizującej memy
permissionmessage: "Nie masz uprawnień" #Wiadomosc wysyłana do osoby bez uprawnień 
memecommand: "!meme" #komenda do wysłania mema
updatecommand: "!update" #komenda do aktualizacji mema
reloadcommand: "!reload" #komenda do przeładowania konfiguracji
deletecommand: "!usun" #komenda do usuwania wiadomosci


```
## Biblioteki
- yamlconfig
- JDA
- gson
## Download
https://github.com/Gaway-Code/meme-discord-bot/releases
### License
MIT
## Autor

- [@Gaway-code](https://github.com/Gaway-Code)

