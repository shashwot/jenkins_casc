pipelineJob('SECURITY-SAST-SNYK') {
        definition {
          cps {
            script("""\
              pipeline {
                agent any
                stages {
                    stage ('test') {
                        steps {
                            withCredentials([string(credentialsId: 'snyk_auth', variable: 'snyk_auth')]) {
                                sh '''
                                    cd "\${WORKSPACE}"
                                    SNYK_TOKEN="\${snyk_auth}" snyk test 
                                    SNYK_TOKEN="\${snyk_auth}" snyk monitor
                                    SNYK_TOKEN="\${snyk_auth}" snyk test --json
                                '''
                            }
                        }
                    }
                }
            }""".stripIndent())
          }
        }
      }