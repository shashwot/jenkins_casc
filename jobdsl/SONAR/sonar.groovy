pipelineJob('SECURITY-SONARQUBE') {
        definition {
          cps {
            script("""\
              pipeline {
                agent any
                stages {
                    stage ('test') {
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