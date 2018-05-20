pipeline {
  agent any
  tools {
    maven = tool 'Apache Maven'
  }
  stages {  
    stage("Preparation") {
      git 'https://github.com/ghill1011/walenda.git'
    }
    stage('Build') {
      // Run the maven build
      if (isUnix()) {
        sh "'${maven}/bin/mvn' clean package"
      } else {
        bat(/"${maven}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
    }
    stage("Deploy") {
      pushToCloudFoundry cloudSpace: 'development', credentialsId: 'fed76caa-7a01-4242-844c-1196605f2175', organization: 'Gregg', target: 'https://api.run.pivotal.io'
    }
  }
}
