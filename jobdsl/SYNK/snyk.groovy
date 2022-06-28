pipelineJob('SECURITY-SAST-SNYK') {
        definition {
          cps {
            script("""\
              pipeline {
                agent any
                stages {
                    stage ('test') {
                        steps {
                            withCredentials([string(credentialsId: 'snyk-auth', variable: 'snyk-auth')]) {
                                sh '''
                                    cd "\${WORKSPACE}"
                                    SNYK_TOKEN="\${snyk-auth}" snyk test 
                                    SNYK_TOKEN="\${snyk-auth}" snyk monitor
                                    SNYK_TOKEN="\${snyk-auth}" snyk test --json
                                '''
                            }
                        }
                    }
                }
            }""".stripIndent())
          }
        }
      }