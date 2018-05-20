pipeline {
  agent any
  stages {
    stage("Fetch Repository") {
      steps {
        git 'https://github.com/ghill1011/walenda.git'
      }
    }
    stage('Build') {
      steps {
          sh "'mvn' clean package"
      }
    }
    stage("Deploy") {
      steps {
        pushToCloudFoundry cloudSpace: 'development', credentialsId: 'fed76caa-7a01-4242-844c-1196605f2175', organization: 'Gregg', target: 'https://api.run.pivotal.io'
      }
    }
  }
}
