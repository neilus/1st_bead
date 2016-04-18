*** Settings ***
Library  OperatingSystem
Library  String

*** Variables ***
${classpath}=   ./build/classes/main
${main}=   Main2
*** Test Cases ***
Without input
    [Documentation]  paraméter nélkül futtatva
    [Tags]  invalid     Main2   noparams    noinput
    ${output}=  Run     java -classpath ${classpath} ${main}
#    Log To Console  ${output}
    Should Contain  ${output}   ERROR: pontosan egy paramétert várok:

File does not exist
    [Documentation]  Nem létező fájlt adva paraméternek
    [Tags]  invalid     Main2
    ${output}=  Run Main2  nem_vagyok_sehol.se
#    Log To Console  ${output}
    Should Contain  ${output}    No such file or directory

Run input1
    [Documentation]  Első input fájllal futtatva
    [Tags]  input1   Main2
    ${output}=  Run Main2   input1.txt
#    Log To Console      ${output}
    Should Contain  ${output}   Vandor

Run input2
    [Documentation]  Második input fájllal futtatva
    [Tags]  input2  Main2
    ${output}=  Run Main2  input2.txt
#    Log To Console      ${output}
    Should Contain  ${output}   ;(

*** Keywords ***
Run Main2
    [Documentation]     Runs the Main2 application with the given inputfile as a parameter
    [Arguments]     ${inputfile}
    ${output}=      Run  java -classpath ${classpath} ${main} ./${inputfile}
    [Return]  ${output}

