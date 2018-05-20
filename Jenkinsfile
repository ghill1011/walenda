pipeline {
  agent any
  tools {
    maven = 'Apache Maven'
  }
  stages {
    stage("Preparation") {
      steps {
        git 'https://github.com/ghill1011/walenda.git'
      }
    }
    stage('Build') {
      steps {
        //step {
        // Run the maven build
        if (isUnix()) {
          sh "'${maven}/bin/mvn' clean package"
        } else {
          bat(/"${maven}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
        //}
      }
    }
    stage("Deploy") {
      steps {
        pushToCloudFoundry cloudSpace: 'development', credentialsId: 'fed76caa-7a01-4242-844c-1196605f2175', organization: 'Gregg', target: 'https://api.run.pivotal.io'
      }
    }
  }
}
