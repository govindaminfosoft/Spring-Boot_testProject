def COLOR_MAP = [
'SUCCESS': 'good',
'FAILURE': 'danger',
]
pipeline {
    agent any
    stages {
        stage('Git Clone'){
      steps {
        script {
                    echo("${env.GIT_BRANCH}")
                if ("${env.GIT_BRANCH}" == 'origin/release/production') {
                        sh 'cp src/main/resources/application-prod.yml  src/main/resources/application.yml'
                     } else if ("${env.GIT_BRANCH}" == 'origin/master') {
                        sh 'cp src/main/resources/application-dev.yml  src/main/resources/application.yml'
                     }
                     else if ("${env.GIT_BRANCH}" == 'origin/develop') {
                        sh 'cp src/main/resources/application-develop.yml  src/main/resources/application.yml'
                      }
                      else if ("${env.GIT_BRANCH}" == 'origin/qa') {
                        sh 'cp src/main/resources/application-qa.yml  src/main/resources/application.yml'
                      }
                    }
                  }
                }
    stage("Maven Build"){
      environment {
            mavenHome =  tool name: "maven-3_6_3", type: "maven"
            mavenCMD = "${mavenHome}/bin/mvn"
        }

      steps {
            sh "${mavenCMD} clean package"
               // sh "${mavenCMD} spring-boot:run"
               sh "cp target/realestatecrm.war  C:/apache-tomcat-9.0.50/webapps/"
          }
      }
    }

 }
