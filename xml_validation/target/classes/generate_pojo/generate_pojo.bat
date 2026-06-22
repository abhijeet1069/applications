@echo off
echo ========================================
echo JAXB XSD -> POJO Code Generator (xjc)
echo ========================================

REM ---- EDIT THESE PATHS IF NEEDED ----

set XJC="C:\Program Files\OpenLogic\jdk-8.0.422.05-hotspot\bin\xjc.exe"
set XSD="C:\Personal\DSA\Algorithms-main\ADM_Java\AlgoExperiments\src\main\resources\list\list.xsd"
set OUT="C:\Personal\DSA\Algorithms-main\ADM_Java\AlgoExperiments\src\main\java"
set PKG=com.satyam.algoexp.list.model

REM ---- RUN XJC ----

%XJC% -no-header -npa -d %OUT% -p %PKG% %XSD%

echo.
echo ✅ DONE! Classes generated in: %OUT%\%PKG%
echo.
pause
