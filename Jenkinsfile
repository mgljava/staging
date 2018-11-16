pipeline {
  agent {
    node {
      label "jenkins-agent"
    }
  }
  stages {
    stage('Compile & Check') {
      steps {
        sh './gradlew clean check'
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/checkstyle', reportFiles: 'main.html', reportName: 'Checkstyle Report', reportTitles: 'Checkstyle Report'])
      }
    }
    stage('Package') {
        steps {
            sh './gradlew clean build'
            stash includes: 'build/libs/*.jar', name: 'staging-jar'
        }
    }
  }
}
