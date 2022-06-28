pipelineJob('SECURITY-SONARQUBE') {
        definition {
          cps {
            script("""\
              pipeline {
                agent any
                stages {
                    stage('Initialize') {
                        steps {
                            script {
                                properties([
                                buildDiscarder(logRotator(daysToKeepStr: '5', numToKeepStr: '5'))])
                            }
                        }
                    }
                    stage ('SONAR') {
                        steps {
                            sh '''
                                # npm run sonar
                            '''
                        }
                    }
                }
            }""".stripIndent())
          }
        }
      }