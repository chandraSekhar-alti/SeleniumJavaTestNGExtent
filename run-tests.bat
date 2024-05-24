@echo off

REM Navigates to the JSON-Server directory
cd JSON-Server

REM starts the json server in the background
start npx json-server db.json

REM give some time to the server to start
timeout /t 10 /nobreak

REM navigate to the project root directory
cd ..

REM run the maven tests
mvn clean test

REM Kill the json-server process
taskkill /F /IM node.exe

REM Ensure the allure-results directory exists
if not exist "allure-results" mkdir "allure-results"
