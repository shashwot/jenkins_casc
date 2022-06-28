pipelineJob('SECURITY-SAST-SNYK') {
definition {
    cps {
    script("""\
        pipeline {
        agent any
        stages {
            stage ('SNYK') {
            steps {
                withCredentials([string(credentialsId: 'snyk-auth', variable: 'snyk-auth')]) {
                script {
                sh '''
                    cd '\${WORKSPACE}'
                    SNYK_TOKEN='\${snyk-auth}' snyk test 
                    SNYK_TOKEN='\${snyk-auth}' snyk monitor
                    SNYK_TOKEN='\${snyk-auth}' snyk test -json | SNYK_TOKEN='\${snyk-auth}' snyk-to-html -o results.html
                '''
                }
                }
            }
            }
        }
        }""".stripIndent())
    }
}
}