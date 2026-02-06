@echo off
chcp 65001 >nul

set OUTPUT=info.txt

echo ===== Informace o uživateli ===== > %OUTPUT%
echo Datum a čas: %DATE% %TIME% >> %OUTPUT%
echo. >> %OUTPUT%

echo Uživatelské jméno: %USERNAME% >> %OUTPUT%
echo Doména / PC: %USERDOMAIN% >> %OUTPUT%
echo Domovská složka: %USERPROFILE% >> %OUTPUT%
echo. >> %OUTPUT%

echo ===== Informace o systému ===== >> %OUTPUT%
systeminfo | findstr /B /C:"OS Name" /C:"OS Version" /C:"System Type" >> %OUTPUT%
echo. >> %OUTPUT%

echo ===== Síť ===== >> %OUTPUT%
ipconfig | findstr /C:"IPv4" >> %OUTPUT%

echo. >> %OUTPUT%
echo Hotovo. Informace uloženy do %OUTPUT%.
pause
