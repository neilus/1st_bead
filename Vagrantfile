Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.provision "shell", inline: <<-SHELL
  echo "------- add oracle JDK PP/repository --------------------------------"
  sudo add-apt-repository ppa:webupd8team/java -y

  echo "------- update the sources list -------------------------------------"
  sudo apt-get update -qq

  echo "------- Accept the Oracle JDK licence agreement ---------------------"
  echo debconf shared/accepted-oracle-license-v1-1 select true | \
    sudo debconf-set-selections
  echo debconf shared/accepted-oracle-license-v1-1 seen true | \
    sudo debconf-set-selections

  echo "------- install Oracle Java 8 JDK and set it as default java --------"
  sudo apt-get install -yq oracle-java8-installer oracle-java8-set-default
  SHELL

  config.vm.provision "shell",
    run: "always",
    inline: "java -version"
  # build with gradle, including tests
  config.vm.provision "shell",
    run: "always",
    inline: "export set TERM='dumb'; cd /vagrant && ./gradlew build"
end
