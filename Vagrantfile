Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.hostname = "teszter"
  config.vm.provision "shell", inline: <<-SHELL
  export TERM='dumb'
  export USERNAME='vagrant'
  echo "------- add oracle JDK PPA/repository --------------------------------"
  add-apt-repository ppa:webupd8team/java -y

  echo "------- update the sources list -------------------------------------"
  apt-get update -qq

  echo "------- Accept the Oracle JDK licence agreement ---------------------"
  echo debconf shared/accepted-oracle-license-v1-1 select true | \
    debconf-set-selections
  echo debconf shared/accepted-oracle-license-v1-1 seen true | \
    debconf-set-selections

  echo "------- install Oracle Java 8 JDK and set it as default java --------"
  apt-get install -qqy oracle-java8-installer oracle-java8-set-default

  echo "------- Downloading and Installing jython 2.7.0 ---------------------"
  wget http://search.maven.org/remotecontent?filepath=org/python/jython-installer/2.7.0/jython-installer-2.7.0.jar -O jython-installer-2.7.0.jar --no-verbose
  mkdir -p /opt/jython
  chown $USERNAME:$USERNAME -R /opt/jython
  java -jar jython-installer-2.7.0.jar --silent --type standard --directory /opt/jython
  export PATH=$PATH:'/opt/jython/bin'
  echo 'export PATH=$PATH:"/opt/jython/bin"' >> /home/$USERNAME/.bashrc
  echo 'export JYTHON_HOME="/opt/jython"' >> /home/$USERNAME/.bashrc
  echo 'export PATH=$PATH:"/opt/jython/bin"' >> /root/.bashrc
  echo 'export JYTHON_HOME="/opt/jython"' >> /root/.bashrc

  echo "------- Installing the ROBOT framework with Jython pip ---------------"
  jython -m ensurepip
  jython -m pip -q install robotframework

  echo "------- enabling the gradle daemon -----------------------------------"
  sudo su - $USERNAME
  mkdir -p ~$USERNAME/.gradle
  echo 'org.gradle.daemon=true' > ~$USERNAME/.gradle/gradle.properties
  cd /vagrant
  echo "downloading gradle and it's dependencies if not available, please wait.."
  ./gradlew clean >>gradlew.log
  SHELL

  config.vm.provision "shell",
    run: "always",
    inline: "java -version"
  # build with gradle, including tests
  config.vm.provision "shell",
    run: "always",
    inline: <<-SHELL
    export USERNAME='ubuntu'
    sudo su - $USERNAME
    cd /vagrant
    echo "------- building and running tests -------------------------------------"
    ./gradlew build | tee gradlew.log
    SHELL
end
