@echo off

REM Navigates to the JSON-Server directory
cd JSON-Server

REM starts the json server in the background
start npx json-server db.json

REm give some times to server to start
timeout /t 10 /nobreak

REM navigate to the project root directory
cd ..

REM run the maven tests
mvn clean test

REM kill the json-server process
taskkill /F /IM node.exe