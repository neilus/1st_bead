*** Settings ***
Documentation  Tesztelés különböző inputokkal
Library  OperatingSystem
Library  String

*** Variables ***
${classpath}=   ./build/classes/main
${inputpath}=   ./src/test/input/
${main}=   Main2
*** Test Cases ***
Nincs Input
    [Documentation]  paraméter nélkül futtatva
    [Tags]  invalid     Main2   noparams    noinput
    ${output}=  Run     java -classpath ${classpath} ${main}
#    Log To Console  ${output}
    Should Contain  ${output}   ERROR: pontosan egy paramétert várok

Nem létező fájl
    [Documentation]  Nem létező fájlt adva paraméternek
    [Tags]  invalid     Main2
    ${output}=  Run Main2  nem_vagyok_sehol.se
#    Log To Console  ${output}
    Should Contain  ${output}    No such file or directory

Szárazság
    [Documentation]  Túl hosszú napos időszak végére minden faj elpusztul
    [Tags]  input2  Main2
    ${output}=  Run Main2  szarazsag.txt
    Should Contain  ${output}   ;(

Holtverseny
    [Documentation]  Holtverseny eseten a listaban az elso gyoz
    ${output}=  Run Main2  holtverseny.txt
    Should Contain  ${output}   Bela

Tobbletviz
    [Documentation]  Ha tobb vizet kap a maxnál azt nem tudja elraktározni
    ${output}=  Run Main2  pluszmaxviz.txt
    Should Contain  ${output}  ;(

Napos
    [Documentation]  ..időben a Homokjáró a favorit
    ${output}=  Run Main2  naposido.txt
    Should Contain  ${output}  Homokjáró

Felhős
    [Documentation]  ..időben a Lépegető a leggyorsabb
    ${output}=  Run Main2  felhosido.txt
    Should Contain  ${output}  Lépegető

Esős
    [Documentation]  ..időben a Szivacs a leggyorsabb
    ${output}=  Run Main2  esosido.txt
    Should Contain  ${output}  Szivacs

Sample
    [Documentation]  A feladatkiírásban szereplő inputtal
    [Tags]  input1   Main2
    ${output}=  Run Main2   input1.txt
#    Log To Console      \n${output}
    Should Contain  ${output}   Vandor

*** Keywords ***
Run Main2
    [Documentation]     Runs the Main2 application with the given inputfile as a parameter
    [Arguments]     ${inputfile}
    ${output}=      Run  java -classpath ${classpath} ${main} ${inputpath}${inputfile}
    [Return]  ${output}

