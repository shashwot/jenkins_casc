job('SECURITY-SAST-SNYK') {
  withCredentials([string(credentialsId: 'snyk_auth', variable: 'snyk_auth')]) {
  steps {
    shell('''cd ${WORKSPACE}
SNYK_TOKEN="${snyk_auth}" snyk test 
SNYK_TOKEN="${snyk_auth}" snyk monitor
      ''')
  }
  }
}