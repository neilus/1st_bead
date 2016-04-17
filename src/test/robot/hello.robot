*** Settings ***
Library  OperatingSystem

*** Test Cases ***

Greet the World
    Log To Console      Hello World!

Run an echo
    ${output}=  Run     echo "Hello Robot!"
    Log To Console      ${output}

Run input1
    [Tags]  input1   Main2
    ${1st_output}=  Run Main2   input1.txt
    Log To Console      ${1st_output}

Run input2
    [Tags]  input2   Main2
    Run Main2       input2.txt
Run java Main2 with input2
    [Tags]  input2   Main2
    ${output2}=  Run    java -classpath /vagrant/build/classes/main Main2 /vagrant/input2.txt
    Log To Console      ${output2}
*** Keywords ***
Run Main2
    [Arguments]     ${inputfile}
    ${output}=  Run    java -classpath /vagrant/build/classes/main/ Main2 /vagrant/${inputfile}
    [Return]  ${output}

