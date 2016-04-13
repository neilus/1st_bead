Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.provision "shell", inline: <<-SHELL
  export TERM='dumb'
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
  apt-get install -yq oracle-java8-installer oracle-java8-set-default
  echo "------- enabling the gradle daemon ----------------------------------"
  sudo su - vagrant
  mkdir -p ~vagrant/.gradle
  echo 'org.gradle.daemon=true' > ~vagrant/.gradle/gradle.properties
  SHELL

  config.vm.provision "shell",
    run: "always",
    inline: "java -version"
  # build with gradle, including tests
  config.vm.provision "shell",
    run: "always",
    inline: <<-SHELL
    sudo su - vagrant
    #export TERM='dumb'
    cd /vagrant
    echo "downloading gradle and it's dependencies if not available, please wait.."
    ./gradlew clean >>gradlew.log
    echo "------- building and running tests -------------------------------------"
    ./gradlew build | tee gradlew.log
    SHELL
end
