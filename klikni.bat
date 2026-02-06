@echo off
setlocal

set "OUTPUT=%TEMP%\info.txt"

echo ===== Informace o uzivateli ===== > "%OUTPUT%"
echo Datum a cas: %DATE% %TIME% >> "%OUTPUT%"
echo. >> "%OUTPUT%"

echo Uzivatelske jmeno: %USERNAME% >> "%OUTPUT%"
echo Pocitac / domena: %USERDOMAIN% >> "%OUTPUT%"
echo Domovska slozka: %USERPROFILE% >> "%OUTPUT%"
echo. >> "%OUTPUT%"

echo ===== System ===== >> "%OUTPUT%"
systeminfo | findstr /B /C:"OS Name" /C:"OS Version" /C:"System Type" >> "%OUTPUT%"
echo. >> "%OUTPUT%"

echo ===== Sit ===== >> "%OUTPUT%"
ipconfig | findstr "IPv4" >> "%OUTPUT%"

echo.
echo Hotovo. Soubor ulozen v:
echo %OUTPUT%
pause
